/*
 * Copyright 2015-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package mis.integration.ariadna.file;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.integration.file.FileHeaders;
import org.springframework.integration.transformer.Transformer;
import org.springframework.integration.zip.ZipHeaders;
import org.springframework.integration.zip.transformer.AbstractZipTransformer;
import org.springframework.integration.zip.transformer.SpringZipUtils;
import org.springframework.integration.zip.transformer.ZipResultType;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandlingException;
import org.springframework.util.Assert;
import org.zeroturnaround.zip.ByteSource;
import org.zeroturnaround.zip.ZipEntrySource;

import java.util.ArrayList;
import java.util.Date;
import java.util.zip.Deflater;

/**
 * Special version for MIS protocol
 *
 * {@link Transformer} implementation that applies a Zip transformation to the
 * message payload. Keep in mind that Zip entry timestamps are recorded only to
 * two 2 second precision:
 * <p>
 * See also:  http://mindprod.com/jgloss/zip.html
 * <p>
 * If you want to generate Zip files larger than {@code 4GB}, you must use Java 7:
 * <p>
 * See also: https://blogs.oracle.com/xuemingshen/entry/zip64_support_for_4g_zipfile
 *
 * @author Gunnar Hillert
 * @since 1.0
 */
public class ZipTransformer extends AbstractZipTransformer {

  private static final Log logger = LogFactory.getLog(ZipTransformer.class);

  private static final String ZIP_EXTENSION = ".zip";

  private static final String ZIP_HEADER_NAME = "zip_name";

  private volatile int compressionLevel = Deflater.DEFAULT_COMPRESSION;

  public ZipTransformer() {
    zipResultType = ZipResultType.BYTE_ARRAY;
  }

  /**
   * Sets the compression level. Default is {@link Deflater#DEFAULT_COMPRESSION}.
   *
   * @param compressionLevel Must be an integer value from 0-9.
   */
  public void setCompressionLevel(int compressionLevel) {
    Assert.isTrue(compressionLevel >= 0 && compressionLevel <= 9, "Acceptable levels are 0-9");
    this.compressionLevel = compressionLevel;
  }

  /**
   * The payload may encompass the following types:
   * <p>
   * <ul>
   * <li>{@link File} - unsupported!
   * ...<li>{@link String}
   * ...<li>byte[]
   * ...<li>{@link Iterable}
   * </ul>
   * <p>
   * When providing an {@link Iterable}, nested Iterables are not supported. However,
   * payloads can be of of any of the other supported types.
   */
  @Override
  protected Object doZipTransform(Message<?> message) throws Exception {

    try {

      final Object payload = message.getPayload();
      final Object zippedData;
      final String baseFileName = this.fileNameGenerator.generateFileName(message);

      final String zipFileName;
      if (message.getHeaders().containsKey(ZIP_HEADER_NAME)) {
        zipFileName = (String) message.getHeaders().get(ZIP_HEADER_NAME);
      } else {
        zipFileName = baseFileName + ZIP_EXTENSION;
      }
      final Date lastModifiedDate;

      if (message.getHeaders().containsKey(ZipHeaders.ZIP_ENTRY_LAST_MODIFIED_DATE)) {
        lastModifiedDate = (Date) message.getHeaders().get(ZipHeaders.ZIP_ENTRY_LAST_MODIFIED_DATE);
      } else {
        lastModifiedDate = new Date();
      }

      java.util.List<ZipEntrySource> entries = new ArrayList<ZipEntrySource>();

      if (payload instanceof Iterable<?>) {
        for (Object item : (Iterable<?>) payload) {

          final ZipEntrySource zipEntrySource = createZipEntrySource(item, lastModifiedDate);
          if (logger.isDebugEnabled()) {
            logger.debug("ZipEntrySource path: '" + zipEntrySource.getPath() + "'");
          }
          entries.add(zipEntrySource);
        }
      } else {
        final ZipEntrySource zipEntrySource =
            createZipEntrySource(payload, lastModifiedDate);
        entries.add(zipEntrySource);
      }

      final byte[] zippedBytes = SpringZipUtils.pack(entries, this.compressionLevel);

      if (ZipResultType.FILE.equals(this.zipResultType)) {
        throw new RuntimeException("Unsupported payload type. Use standard zip-transformer");
      } else if (ZipResultType.BYTE_ARRAY.equals(this.zipResultType)) {
        zippedData = zippedBytes;
      } else {
        throw new IllegalStateException("Unsupported zipResultType " + this.zipResultType);
      }

      return getMessageBuilderFactory()
          .withPayload(zippedData)
          .copyHeaders(message.getHeaders())
          .setHeader(FileHeaders.FILENAME, zipFileName)
          .build();
    } catch (Exception e) {
      throw new MessageHandlingException(message, "Failed to apply Zip transformation.", e);
    }
  }

  private ZipEntrySource createZipEntrySource(Object item, Date lastModifiedDate) {

    //Требование протокола ЛИС
    final String zipEntryName = (item instanceof String) ? "manifest.xml" : "manifest.pdf";

    if (item instanceof byte[] || item instanceof String) {

      final byte[] bytesToCompress;

      if (item instanceof String) {
        bytesToCompress = ((String) item).getBytes(this.charset);
      } else {
        bytesToCompress = (byte[]) item;
      }

      return new ByteSource(zipEntryName, bytesToCompress, lastModifiedDate.getTime());
    } else {
      throw new IllegalArgumentException("Unsupported payload type. The only supported payloads are " +
          "java.lang.String, and byte[]");
    }
  }

}
