/**
 * Class that performs simple substitution encryption and decryption 
 * using the ASCII table and a key up to the value 255 (8-bit).
 */
public class SubstitutionEncrypter implements Encryptor {

    /**
     * Encrypts a message using the provided numeric key by shifting ASCII values to the right by the key value.
     * 
     * @param message - The plaintext to be encrypted.
     * @param key - Defines how many times to shift the ASCII value to the right.
     * @return - The encrypted ciphertext.
     */
    public String encrypt(String message, int key) {

        if (key > 255) {
            throw new IllegalArgumentException("Key value must be under 255");
        }

        char[] messageChars = message.toCharArray();
        StringBuilder encryptedResult = new StringBuilder();

        // Convert char to ASCII, add key value, then convert back to char
        for (char character : messageChars) {
            int asciiValue = (int) character;
            int shiftedAsciiValue = asciiValue + key;

            // Handle wrap-around if value exceeds 255
            if (shiftedAsciiValue > 255) {
                shiftedAsciiValue -= 256;   
            }

            char encryptedCharacter = (char) shiftedAsciiValue;
            encryptedResult.append(encryptedCharacter);
        }

        return encryptedResult.toString();
    }

    /**
     * Decrypts a cipher by shifting the ASCII value to the left by the key value.
     * 
     * @param cipher - The encrypted message.
     * @param key - Defines how many times to shift the ASCII value to the left.
     * @return - The decrypted plaintext.
     */
    public String decrypt(String cipher, int key) {

        if (key > 255) {
            throw new IllegalArgumentException("Key value must be under 255");
        }

        char[] cipherChars = cipher.toCharArray();
        StringBuilder decryptedResult = new StringBuilder();

        // Convert char to ASCII, remove key value, then convert back to char
        for (char character : cipherChars) {
            int asciiValue = (int) character;
            int shiftedAsciiValue = asciiValue - key;

            // Handle wrap around if the ASCII value is lower than 0
            if (shiftedAsciiValue < 0) {
                shiftedAsciiValue += 256;   
            }

            char decryptedCharacter= (char) shiftedAsciiValue;
            decryptedResult.append(decryptedCharacter);
        }

        return decryptedResult.toString();
    }
}
