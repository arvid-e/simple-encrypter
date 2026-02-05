interface Encryptor {
    public String encrypt(String plainText, int key);
    public String decrypt(String cipherText, int key);
}