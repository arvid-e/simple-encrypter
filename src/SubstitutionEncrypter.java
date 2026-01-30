/**
 * Class that performs simple substitution encryption and decryption 
 * using the ASCII table and a key up to the value 255 (8-bit).
 */
public class SubstitutionEncrypter {

    /**
     * Method for encrypting a message by shifting ASCII values to the right by the key amount.
     */
    public String encrypt(String message, int key) {

        if (key > 255) {
            throw new IllegalArgumentException("Key value must be under 255");
        }

        char[] messageChars = message.toCharArray();
        StringBuilder encryptedResult = new StringBuilder();

        for (char letter : messageChars) {
            int asciiValue = (int) letter;
            int shiftedAsciiValue = asciiValue + key;

            // Handle wrap-around if value exceeds 255
            if (shiftedAsciiValue > 255) {
                shiftedAsciiValue -= 256;   
            }

            char encryptedLetter = (char) shiftedAsciiValue;
            encryptedResult.append(encryptedLetter);
        }

        return encryptedResult.toString();
    }

    /**
     * Method for decrypting a cipher by shifting the ASCII value to the left by the key amount.
     */
    public String decrypt(String cipher, int key) {

        if (key > 255) {
            throw new IllegalArgumentException("Key value must be under 255");
        }

        char[] cipherChars = cipher.toCharArray();
        StringBuilder decryptedResult = new StringBuilder();

        for (char letter : cipherChars) {
            int asciiValue = (int) letter;
            int shiftedAsciiValue = asciiValue - key;

            // Handle wrap around if the ASCII value is lower than 0
            if (shiftedAsciiValue < 0) {
                shiftedAsciiValue += 256;   
            }

            char decryptedLetter = (char) shiftedAsciiValue;
            decryptedResult.append(decryptedLetter);
        }

        return decryptedResult.toString();
    }
}
