public class TranspositionEncryptor {
    
    public void encrypt(String message, int key) {

        char[] messageChars = message.toCharArray();
        StringBuilder encryptedResult = new StringBuilder();
        Character[] transpositionArrayList = new Character[message.length()];

        String keyString = String.valueOf(key);
        char[] keyChars = keyString.toCharArray();

        int[] keyArr = new int[keyString.length()];

        for (int i = 0; i < keyChars.length; i++) {
            keyArr[i] = Character.getNumericValue(keyChars[i]) -1;
        }

        int blockSize = keyString.length();
        int rowAmount = message.length() / blockSize;
        int rowIndex = 0;

        int[] currentIndexes = new int[blockSize];

        // sets to [6, 0, 12]
        for (int i = 0; i < blockSize; i++) {
            currentIndexes[keyArr[i]] = rowIndex;
            rowIndex += rowAmount;
        }

        for (int i = 0; i < messageChars.length; i++) {
            transpositionArrayList[currentIndexes[i]] = messageChars[i];
            // transpositionArrayList.add(currentIndexes[i], messageChars[i]);
            currentIndexes[i] += 1;
        }


        for (char character : transpositionArrayList) {
            System.out.println(character);
        }
        


    }
}
