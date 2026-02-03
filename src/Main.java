public class Main {
    public static void main(String[] args) {
        SubstitutionEncrypter substitutionEncrypter = new SubstitutionEncrypter();
        TranspositionEncryptor transpositionEncryptor = new TranspositionEncryptor();

        String secret = "secret message coming through";
        transpositionEncryptor.encrypt(secret, 214);

        // String secret = "secret";
        // String encryptedSecret = substitutionEncrypter.encrypt(secret, 180);
        // System.out.println(encryptedSecret);

        // String decryptedSecret = substitutionEncrypter.decrypt(encryptedSecret, 180);
        // System.out.println(decryptedSecret);

        
    }
}