public class Main {
    public static void main(String[] args) {
        SubstitutionEncrypter substitutionEncrypter = new SubstitutionEncrypter();
        TranspositionEncryptor transpositionEncryptor = new TranspositionEncryptor();

        String secret = "secret message coming through";
        String cipher = transpositionEncryptor.encrypt(secret, 214);

        String decrypted = transpositionEncryptor.decrypt(cipher, 214);
        System.out.println(decrypted);

        // String secret = "secret";
        // String encryptedSecret = substitutionEncrypter.encrypt(secret, 180);
        // System.out.println(encryptedSecret);

        // String decryptedSecret = substitutionEncrypter.decrypt(encryptedSecret, 180);
        // System.out.println(decryptedSecret);

        
    }
}