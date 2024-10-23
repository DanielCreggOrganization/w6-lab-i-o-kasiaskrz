
import  java.io.FileReader;
import java.io.IOException;

public class FileReverser {
    public static void main(String[] args) {
        FileReader reader = null;
        try {
            reader = new FileReader("/workspaces/w6-lab-i-o-kasiaskrz/resources/input.txt");
            int character;
            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println("Error closing reader: " + e.getMessage());
            }
        }
    }
}
