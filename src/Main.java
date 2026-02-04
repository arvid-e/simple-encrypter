public class Main {
    public static void main(String[] args) {
        SubstitutionEncrypter substitutionEncrypter = new SubstitutionEncrypter();
        TranspositionEncryptor transpositionEncryptor = new TranspositionEncryptor();

        String secret = "secret message coming through";
        System.out.println("Message to encrypt: " + secret);

        System.out.println();

        String transpositionCipher = transpositionEncryptor.encrypt(secret, 214);
        System.out.println("Columnal transposition cipher: " + transpositionCipher);

        String decryptedTranspositionCipher = transpositionEncryptor.decrypt(transpositionCipher, 214);
        System.out.println("Decrypted: " + decryptedTranspositionCipher);

        System.out.println();

        String encryptedSubstitutionCipher = substitutionEncrypter.encrypt(secret, 180);
        System.out.println("Simple substitution cipher: " + encryptedSubstitutionCipher);

        String decryptedSubstitutionCipher = substitutionEncrypter.decrypt(encryptedSubstitutionCipher, 180);
        System.out.println("Decrypted: " + decryptedSubstitutionCipher);
    }
}