import java.util.HashMap;

public class TranspositionEncryptor {
    
    public void encrypt(String message, int key) {

        char[] messageChars = message.toCharArray();
        Character[] transpositionArrayList = new Character[message.length()];

        String keyString = String.valueOf(key);

        int blockSize = keyString.length();

        int[] keyArr = new int[blockSize];

        while (message.length() % blockSize != 0) {
            message += " ";
        }

        // creates a [2, 1, 4] array of key
        for (int i = 0; i < blockSize; i++) {
            keyArr[i] = Character.getNumericValue(keyString.charAt(i)) -1;
        }

        // use hashmap because normal array gets out of bounds if a number in key is higher than the blocksize
        HashMap<Integer, Integer> currentIndexMap = new HashMap<>();

        int rowAmount = message.length() / blockSize;
        int rowIndex = 0;

        // sets to [6, 0, 12]
        for (int i = 0; i < blockSize; i++) {
            int keyDigit = keyArr[i];

            currentIndexMap.put(keyDigit, rowIndex);
            rowIndex += rowAmount;
        }

        for (int i = 0; i < messageChars.length; i++) {

            int keyIndex = i % blockSize;
            int keyDigit = keyArr[keyIndex];
            int rowIndexValue = currentIndexMap.get(keyDigit);

            transpositionArrayList[rowIndexValue] = messageChars[i];
            rowIndexValue += 1;

            currentIndexMap.put(keyDigit, rowIndexValue);
        }

        // Test
        String result = "";
        for (char character : transpositionArrayList) {
            result += character;
        }
        
        System.out.println(result);
    }
}
