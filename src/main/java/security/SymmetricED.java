package security;


import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import java.util.Base64;

public class SymmetricED {
    /*
     * using AES standard for encrytion and decryption
     * processes a block of 128 bits of data using secret keys of 128, 192, 256 bits
     * AES - a 128 bit symmetric block ciphertext
     */
    private SecretKey key;
    private final int KEY_SIZE = 128;
    private final int DATA_LENGTH = 128;
    private Cipher cipher;

    public SymmetricED() throws Exception{
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(KEY_SIZE);
        key = keyGenerator.generateKey();
    }

    public String encrypt(String data) throws Exception {
        /**
         * cipher -> algo for hashing?
         */
        byte[] dataInBytes = data.getBytes();
        cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(dataInBytes);
        return encode(encryptedBytes);
    }

    public String decrypt(String data) throws Exception {
        byte[] dataInBytes = decode(data);
        Cipher decrytionCipher = Cipher.getInstance("AES/GCM/NoPadding");
        GCMParameterSpec spec = new GCMParameterSpec(DATA_LENGTH, cipher.getIV());
        decrytionCipher.init(Cipher.DECRYPT_MODE, key, spec);
        byte[] decryptedBytes = decrytionCipher.doFinal(dataInBytes);
        return new String(decryptedBytes);
    }

    private String encode(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }

    private byte[] decode(String data) {
        return Base64.getDecoder().decode(data);
    }

    public static void main(String[] args) throws Exception{
        SymmetricED aes = new SymmetricED();
        String encryptedData = aes.encrypt("HElllo d");
        String decryptedData = aes.decrypt(encryptedData);

        System.out.println("Encrypted data: " + encryptedData);
        System.out.println("Decrypted data: " + decryptedData);
    }
}
