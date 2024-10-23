import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class FileReverser5 {
    public static void main(String[] args) {
        ArrayList<String> lines = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader("/workspaces/w6-lab-i-o-kasiaskrz/resources/input.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }
        
        Collections.reverse(lines);
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("/workspaces/w6-lab-i-o-kasiaskrz/resources/output.txt"))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}