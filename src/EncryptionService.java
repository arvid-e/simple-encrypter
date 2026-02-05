/**
 * Class that takes in the method of encryption and perform encryption or decryption 
 * using the choosen method.
 */
public class EncryptionService {
    String text;
    int key;
    Encryptor encryptor;

    /**
     * Initializer an encryption service that uses inputted cipher method.
     * 
     * @param encryptor - Method of encryption.
     * @param text - Plaintext or ciphertext.
     * @param key - Cipher key.
     */
    public EncryptionService(Encryptor encryptor, String text, int key) {
        this.text = text;
        this.key = key;
        this.encryptor = encryptor;
    }

    public String encrypt() {
        return encryptor.encrypt(this.text, this.key);
    }

    public String decrypt() {
        return encryptor.decrypt(this.text, this.key);
    }


}