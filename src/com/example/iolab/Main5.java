package com.example.iolab;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main5 {
    public static void main(String[] args) {
        String inputPath = "resources/input.txt";
        String outputPath = "resources/output.txt";

        int vowelCount = 0; // Initialize the vowel counter
        int totalCharacterCount = 0;

        try (FileReader reader = new FileReader(inputPath);
                FileWriter writer = new FileWriter(outputPath, true)) {

            int data;
            while ((data = reader.read()) != -1) {
                char character = (char) data; // Convert int to char

                // Check if the character is a vowel
                if (isVowel(character)) {
                    vowelCount++; // Increment the vowel counter
                }
                totalCharacterCount++;

                writer.write(character); // Write the character to output.txt
            }
            System.out.println("File copied successfully.");
            System.out.println("Total number of vowels: " + vowelCount); // Print the vowel count
            System.out.println("Total number of characters: " + totalCharacterCount); // Print the total character count
        } catch (IOException e) {
            System.err.println("Error copying file: " + e.getMessage());
        }
    }

    // Helper method to check if a character is a vowel
    private static boolean isVowel(char character) {
        // Check if the character is a vowel (both uppercase and lowercase)
        return "AEIOUaeiou".indexOf(character) != -1;
    }
}
