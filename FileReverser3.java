import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReverser3 {
    public static void main(String[] args) {
        int characterCount = 0;
        try (FileReader reader = new FileReader("/workspaces/w6-lab-i-o-kasiaskrz/resources/input.txt");
                FileWriter writer = new FileWriter("/workspaces/w6-lab-i-o-kasiaskrz/resources/output2.txt")) {
            int character;
            while ((character = reader.read()) != -1) {
                characterCount++;
            }
            writer.write("File's 'input.txt' character count summary: " + characterCount);
        } catch (IOException e) {
            System.out.println("Error with file operations: " + e.getMessage());
        }
    }
}
