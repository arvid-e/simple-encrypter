import java.util.Scanner;

/**
 * Class that handles all the needed console inputs.
 */
public class ConsoleIO {
    String encryptOrDecrypt;
    String cipherMethod;
    int key;
    String filename;
    Scanner scanner = new Scanner(System.in);

    public CipherPayload getInputs() {

        while(true) {
            System.out.println("Do you want to encrypt (E) or decrypt (D)?");
            this.encryptOrDecrypt = this.scanner.nextLine();

            if (this.encryptOrDecrypt.equals("E") || this.encryptOrDecrypt.equals("D")) {
                break;
            }
        }


        while(true) {
            System.out.println("Do you want to use substitution (S) or transposition (T)?");
            this.cipherMethod = this.scanner.nextLine();

            if (this.cipherMethod.equals("S") || this.cipherMethod.equals("T")) {
                break;
            }
        }

        while(true) {
            System.out.println("Input secret key");
            String keyString = this.scanner.nextLine();

            if (keyString.length() > 0) {
                this.key = Integer.parseInt(keyString);
                break;
            }
        }

        while(true) {
            System.out.println("Input name of file to procss: ");
            this.filename = this.scanner.nextLine();

            if (this.filename.length() > 0) {
                break;
            }
        }

        CipherPayload payload = new CipherPayload();

        payload.setCipher(this.cipherMethod);
        payload.setEncryptOrDecrypt(this.encryptOrDecrypt);
        payload.setKey(this.key);
        payload.setFilename(this.filename);

        return payload;
    }
}