import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Stream;

public class Main7 {
    public static void main(String[] args) {
        String inputPath = "resources/input.txt";

        // Reading and counting lines
        try (Stream<String> lines = Files.lines(Paths.get(inputPath))) {
            long lineCount = lines.count();
            System.out.println("Number of lines: " + lineCount);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        // Reading and processing each line
        try (Stream<String> lines = Files.lines(Paths.get(inputPath))) {
            lines.forEach(line -> System.out.println("Line: " + line));
        } catch (IOException e) {
            System.err.println("Error processing file: " + e.getMessage());
        }

        // Filtering lines
        try (Stream<String> lines = Files.lines(Paths.get(inputPath))) {
            long nonEmptyLines = lines
                .filter(line -> !line.trim().isEmpty())
                .count();
            System.out.println("Non-empty lines: " + nonEmptyLines);

        //Word frequency counter
        try (Stream<String> lines = Files.lines(Paths.get(inputPath))) {
            Map<String, Long> wordFreq = lines.flatMap(line -> Arrays.stream(line.split("\\s+")))
                                            .collect(Collectors.groupingBy(word -> word, Collectors.counting()));
                wordFreq.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        // Processing all text files in the resources directory
        try (Stream<Path> paths = Files.list(Paths.get("resources"))
            paths.filter(Files::isRegularFile)) {
                .filter(path -> path.toString().endsWith(".txt"))
                .forEach(path -> {
                    try (Stream<String> lines = Files.lines(path)) {
                        long lineCount = lines.count();
                        System.out.println(path.getFileName() + ": " + lineCount + " lines");  
                    } catch (IOException e) {
                        System.err.println("Error reading file: " + e.getMessage());
                    }
                }};
        } catch (IOException e) {
            System.err.println("Error listing file: " + e.getMessage());
        }
    }
}