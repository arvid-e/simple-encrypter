public class Main {
    public static void main(String[] args) {
        ConsoleIO consoleInputs = new ConsoleIO();
        FileReader fileReader = new FileReader();

        CipherPayload cipherPayload = consoleInputs.getInputs();

        String text = fileReader.readFile(cipherPayload.getFilename());

        EncryptionService encryptionService;
        if (cipherPayload.getCipher().equals("S")) {
            encryptionService = new EncryptionService(
                new SubstitutionEncrypter(), 
                text, 
                cipherPayload.getKey()
            );
        } else {
            encryptionService = new EncryptionService(
                new TranspositionEncryptor(), 
                text, 
                cipherPayload.getKey()
            );
        }

        System.out.println();
        
        String result;
        if (cipherPayload.getEncryptOrDecrypt().equals("E")) {
            result = encryptionService.encrypt();
            fileReader.writeFile("encrypted-message.txt", result);
        } else {
            result = encryptionService.decrypt();
            fileReader.writeFile("decrypted-message.txt", result);
        }
    }
}