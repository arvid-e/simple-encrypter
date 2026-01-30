public class SubstitutionEncrypter {
    public String encrypt(String cipher, int key) {

        if (key > 255) {
            throw new IllegalArgumentException("Key value must be under 255");
        }

        char[] cipherChars = cipher.toCharArray();
        StringBuilder encryptedResult = new StringBuilder();

        for (char letter : cipherChars) {
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
}
