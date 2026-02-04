import java.util.HashMap;

public class TranspositionEncryptor {
    
    public String encrypt(String message, int key) {
        String keyString = String.valueOf(key);
        int blockSize = keyString.length();
        int[] keyDigits = new int[blockSize];

        while (message.length() % blockSize != 0) {
            message += " ";
        }

        char[] messageChars = message.toCharArray();
        Character[] transpositionArrayList = new Character[message.length()];

        for (int i = 0; i < blockSize; i++) {
            keyDigits[i] = Character.getNumericValue(keyString.charAt(i)) -1;
        }

        // use hashmap because normal array gets out of bounds if a number in key is higher than the blocksize
        HashMap<Integer, Integer> currentIndexMap = new HashMap<>();

        int rowAmount = message.length() / blockSize;
        int rowIndex = 0;

        // sets to [6, 0, 12]
        for (int i = 0; i < blockSize; i++) {
            int keyDigit = keyDigits[i];

            currentIndexMap.put(keyDigit, rowIndex);
            rowIndex += rowAmount;
        }

        for (int i = 0; i < messageChars.length; i++) {
            int keyIndex = i % blockSize;
            int keyDigit = keyDigits[keyIndex];
            int rowIndexValue = currentIndexMap.get(keyDigit);

            transpositionArrayList[rowIndexValue] = messageChars[i];
            rowIndexValue += 1;

            currentIndexMap.put(keyDigit, rowIndexValue);
        }

        String result = "";
        for (char character : transpositionArrayList) {
            result += character;
        }

        return result;
    }

    public String decrypt(String cipher, int key) {
        String keyString = String.valueOf(key);
        int blockSize = keyString.length();
        int rowAmount = cipher.length() / blockSize;
        char[] resultArr = new char[cipher.length()];

        for (int i = 0; i < cipher.length(); i++) {
            int keyIndex = i % blockSize;
            int keyDigit = Character.getNumericValue(keyString.charAt(keyIndex));
        
            int columnOrder = keyString.indexOf(String.valueOf(keyDigit));
        
            // Inverse of the encryption
            int sourceIndex = (columnOrder * rowAmount) + (i / blockSize);
            resultArr[i] = cipher.charAt(sourceIndex);
        }

        return new String(resultArr).trim();
    }
}
