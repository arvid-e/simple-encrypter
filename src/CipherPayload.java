/**
 * Data Transfer Object (DTO) for holding cipher operation data.
 */
public class CipherPayload {
    private String text;
    private String encryptOrDecrypt;
    private String cipher;
    private int key;
    private String filename;

    public CipherPayload() {}

    public CipherPayload(String text, String encryptOrDecrypt, String cipher, int key, String filename) {
        this.text = text;
        this.encryptOrDecrypt = encryptOrDecrypt;
        this.cipher = cipher;
        this.key = key;
        this.filename = filename;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getEncryptOrDecrypt() {
        return encryptOrDecrypt;
    }

    public void setEncryptOrDecrypt(String encryptOrDecrypt) {
        this.encryptOrDecrypt = encryptOrDecrypt;
    }

    public String getCipher() {
        return cipher;
    }

    public void setCipher(String cipher) {
        this.cipher = cipher;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }

}