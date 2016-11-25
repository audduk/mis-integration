package mis.integration.ariadna;

import org.springframework.messaging.Message;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Получение md5-digest для строки
 */
public class Md5Transformer {
  public String transform(Message<String> message) throws NoSuchAlgorithmException {
    MessageDigest digest = MessageDigest.getInstance("MD5");
    digest.update(message.getPayload().getBytes());
    final String md5 = new BigInteger(1, digest.digest()).toString();
    return "MD5 (" + message.getHeaders().get("output-file-code") +".XML) = " + md5;
  }
}
