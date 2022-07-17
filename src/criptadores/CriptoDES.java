package criptadores;

import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

public class CriptoDES {

  public static Key keyDES() throws NoSuchAlgorithmException {
      KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
      return keyGenerator.generateKey();
  }

  public static String criptogaphy(String message, Key key) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
      Cipher cipherDES = Cipher.getInstance("DES/ECB/PKCS5Padding");
      cipherDES.init(Cipher.ENCRYPT_MODE, key);
      byte[] secret_message = cipherDES.doFinal(message.getBytes());
      return new String(secret_message);
  }

    public static String descriptogaphy(String secret_message, Key key) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipherDES = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipherDES.init(Cipher.DECRYPT_MODE, key);
        byte[] message = cipherDES.doFinal(secret_message.getBytes());
        return new String(message);
    }

}
