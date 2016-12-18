package mis.integration.ariadna.file;

import org.springframework.integration.transformer.AbstractTransformer;
import org.springframework.messaging.Message;
import sun.misc.BASE64Encoder;

/**
 * Преобразование потока (bytes[]) в Base64
 */
public class Base64Encoder extends AbstractTransformer {
   @Override
   protected Object doTransform(Message<?> message) throws Exception {
      final byte[] bytes = (byte[]) message.getPayload();
      return (new BASE64Encoder()).encodeBuffer(bytes).getBytes();
   }
}
