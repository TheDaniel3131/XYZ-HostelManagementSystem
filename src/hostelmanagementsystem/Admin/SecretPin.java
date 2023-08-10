package hostelmanagementsystem.Admin;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class SecretPin {

    private String secretPin;

    public SecretPin() {
        try {
            secretPin = getSecretPin();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getSecretPin() throws IOException {
        File secretPinFile = new File("secretpin.txt");
        String secretPin;
        try ( Scanner s = new Scanner(secretPinFile)) {
            secretPin = "";
            while (s.hasNextLine()) {
                secretPin = s.nextLine().trim();
                if (!secretPin.isEmpty()) {
                    break;
                }
            }
        }
        return secretPin;
    }

    public String getSecretPinValue() {
        return secretPin;
    }
}
