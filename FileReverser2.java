import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReverser2 {
    public static void main(String[] args) {

        FileReader reader = null;
        FileWriter writer = null;
        try {
            reader = new FileReader("/workspaces/w6-lab-i-o-kasiaskrz/resources/input.txt");
            writer = new FileWriter("/workspaces/w6-lab-i-o-kasiaskrz/resources/output.txt");

            int character;
            while ((character = reader.read()) != -1) {
                writer.write(character);
            }
        } catch (IOException e) {
            System.out.println("Error with file operations: " + e.getMessage());
        } finally {
            try {
                if (reader != null) reader.close();
                if (writer != null) writer.close();
            } catch (IOException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }
}
