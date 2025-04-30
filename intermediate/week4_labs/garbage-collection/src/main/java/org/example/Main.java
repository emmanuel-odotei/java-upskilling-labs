package Week;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Main app = new Main();
        app.readFileWithoutProperClosure("src/main/java/org/example/text.txt");  // Improper method
        app.readFileProperly("src/main/java/org/example/text.txt");  // Improper method
    }

    // This method has the risk of memory leaks because it does not close resources properly
    public void readFileWithoutProperClosure(String filePath) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file " + filePath);
        }
    }

    // This method avoids memory leaks by using the try-with-resources statement
    public void readFileProperly(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file " + filePath);
        }
    }
}