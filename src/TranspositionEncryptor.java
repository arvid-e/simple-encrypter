import java.util.HashMap;

/**
 * Class that implements the Columnar Transposition Cipher.
 * This cipher rearranges the plaintext by writing it into a grid and
 * reading columns back out in the order of the digit values of the key,
 * e.g if key is 214 the order is column 1, 2, 4.
 */
public class TranspositionEncryptor {
    
    /**
     * Encrypts a message using the provided numeric key.
     * 
     * @param message - The plaintext to be encrypted.
     * @param key - The numeric key defining the column order.
     * @return - The encrypted ciphertext.
     */
    public String encrypt(String message, int key) {
        String keyString = String.valueOf(key);
        int blockSize = keyString.length();
        int[] keyDigits = new int[blockSize];

        // Ensures message length is a multiple of blockSize by adding padding spaces.
        // This is necessary to maintain a rectangular grid.
        while (message.length() % blockSize != 0) {
            message += " ";
        }

        char[] messageChars = message.toCharArray();
        Character[] transpositionArrayList = new Character[message.length()];

        // Makes key digits into an array for easier index manipulation.
        for (int i = 0; i < blockSize; i++) {
            keyDigits[i] = Character.getNumericValue(keyString.charAt(i)) -1;
        }

        // Use a HashMap to track the position to add the next character for each column.
        // Needs to use a hashmap because it can handle cases where the biggest digit in key is bigger than the key length.
        HashMap<Integer, Integer> currentIndexMap = new HashMap<>();

        int rowAmount = message.length() / blockSize;
        int rowIndex = 0;

        // Map each key digit to its starting index in the final encrypted array.
        for (int i = 0; i < blockSize; i++) {
            int keyDigit = keyDigits[i];

            currentIndexMap.put(keyDigit, rowIndex);
            rowIndex += rowAmount;
        }

        // Distribute characters into the 'columns' defined by the key order.
        for (int i = 0; i < messageChars.length; i++) {
            int keyIndex = i % blockSize;
            int keyDigit = keyDigits[keyIndex];
            int rowIndexValue = currentIndexMap.get(keyDigit);

            // Add char to correct index and increase row index by 1.
            transpositionArrayList[rowIndexValue] = messageChars[i];
            rowIndexValue += 1;

            currentIndexMap.put(keyDigit, rowIndexValue);
        }

        StringBuilder result = new StringBuilder();

        for (char character : transpositionArrayList) {
            result.append(character);
        }

        return result.toString();
    }

    /**
     * Decrypts a ciphertext by reversing the columnar mapping.
     * 
     * @param cipher The encrypted message.
     * @param key The key used during encryption.
     * @return The decrypted plaintext.
     */
    public String decrypt(String cipher, int key) {
        String keyString = String.valueOf(key);
        int blockSize = keyString.length();
        int rowAmount = cipher.length() / blockSize;
        char[] resultArr = new char[cipher.length()];

        // Reconstruct the original message grid.
        for (int i = 0; i < cipher.length(); i++) {
            int keyIndex = i % blockSize;
            int keyDigit = Character.getNumericValue(keyString.charAt(keyIndex));
        
            // Find the relative order of the current digit within the key.
            int columnOrder = keyString.indexOf(String.valueOf(keyDigit));
        
            /* 
             * Calculate the source index in the ciphertext by locating 
             * the correct column and the current row offset.
             */
            int sourceIndex = (columnOrder * rowAmount) + (i / blockSize);
            resultArr[i] = cipher.charAt(sourceIndex);
        }

        return new String(resultArr).trim();
    }
}
