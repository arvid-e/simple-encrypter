
public class EncryptionService {
    String text;
    int key;
    Encryptor encryptor;

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