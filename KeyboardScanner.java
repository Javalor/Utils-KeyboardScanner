package lang.JaVALOR.utils.KeyboardScanner;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class KeyboardScanner {
    InputStream inputStream = null;
    PrintStream printStream = null;

    public KeyboardScanner() {
        this(System.in,System.out);
    }

    public KeyboardScanner(InputStream inputStream) {
        this(inputStream, System.out);
    }

    public KeyboardScanner(PrintStream printStream) {
        this(System.in, printStream);
    }

    public KeyboardScanner(InputStream inputStream, PrintStream printStream) {
        this.inputStream = inputStream;
        this.printStream = printStream;
    }

    public String getToken() {
        return getToken(" > ");
    }

    public String getToken(String prompt) {

        printStream.printf("%s", prompt);

        try {
            Scanner scanner = new Scanner(inputStream);
            String token = scanner.next();

            // flush buffer
            while (inputStream.available() > 0) { continue; }

            return token;
        }
        catch(Exception ex) {
            return "";
        }

    }
    public String getLine() {
        return getLine(" > ");
    }
    public String getLine(String prompt) {

        printStream.printf("%s", prompt);

        try {
            Scanner scanner = new Scanner(inputStream);
            String token = scanner.nextLine();

            // flush buffer
            while (inputStream.available() > 0) { continue; }

            return token;
        }
        catch(Exception ex) {
            return "";
        }

    }

}
