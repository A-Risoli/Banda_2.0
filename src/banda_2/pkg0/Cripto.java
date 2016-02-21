package banda_2.pkg0;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;


public class Cripto {
    
    private SecretKey secKey ;
    
    public Cripto(String psw){
        

        try {
            byte [] key = psw.getBytes();
            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secKey = new SecretKeySpec(key, "AES");
        } catch (Exception ex) {
            Logger.getLogger(Cripto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
   
            /*byte[] cipherText = encryptText(plainText, secKey);
        String decryptedText = decryptText(cipherText, secKey);
        
        System.out.println("Original Text:" + plainText);
        System.out.println("AES Key (Hex Form):"+bytesToHex(secKey.getEncoded()));
        System.out.println("Encrypted Text (Hex Form):"+bytesToHex(cipherText));
        System.out.println("Descrypted Text:"+decryptedText);
         */

    

    public  byte[] encryptText(String plainText) throws Exception{
		// AES defaults to AES/ECB/PKCS5Padding in Java 7
        Cipher aesCipher = Cipher.getInstance("AES");
        aesCipher.init(Cipher.ENCRYPT_MODE, secKey);
        byte[] byteCipherText = aesCipher.doFinal(plainText.getBytes());
        return byteCipherText;
    }
    


    public  String decryptText(byte[] byteCipherText) throws Exception {
		// AES defaults to AES/ECB/PKCS5Padding in Java 7
        Cipher aesCipher = Cipher.getInstance("AES");
        aesCipher.init(Cipher.DECRYPT_MODE, secKey);
        byte[] bytePlainText = aesCipher.doFinal(byteCipherText);
        return new String(bytePlainText);
    }
    

    private static String  bytesToHex(byte[] hash) {
        return DatatypeConverter.printHexBinary(hash);
    }
}