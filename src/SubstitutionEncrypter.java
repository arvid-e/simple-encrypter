public class SubstitutionEncrypter {
    public String encrypt(String message, int key) {

        if (key > 255) {
            throw new IllegalArgumentException("Key value must be under 255");
        }

        char[] messageChars = message.toCharArray();
        StringBuilder encryptedResult = new StringBuilder();

        for (char letter : messageChars) {
            int asciiValue = (int) letter;
            int shiftedAsciiValue = asciiValue + key;

            if (shiftedAsciiValue > 255) {
                shiftedAsciiValue -= 256;   
            }

            char encryptedLetter = (char) shiftedAsciiValue;

            encryptedResult.append(encryptedLetter);
        }


        return encryptedResult.toString();
    }

    public String decrypt(String cipher, int key) {

        if (key > 255) {
            throw new IllegalArgumentException("Key value must be under 255");
        }

        char[] cipherChars = cipher.toCharArray();
        StringBuilder decryptedResult = new StringBuilder();

        for (char letter : cipherChars) {
            int asciiValue = (int) letter;
            int shiftedAsciiValue = asciiValue - key;

            if (shiftedAsciiValue < 0) {
                shiftedAsciiValue += 256;   
            }

            char decryptedLetter = (char) shiftedAsciiValue;

            decryptedResult.append(decryptedLetter);
        }


        return decryptedResult.toString();
    }
}
