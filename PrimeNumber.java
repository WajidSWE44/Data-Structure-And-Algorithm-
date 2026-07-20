import java.io.*;

public class PrimeNumber{
    public static void main(String[] args) {
        // File paths
        String inputFilePath = "C:\\Users\\computer lab\\OneDrive\\Desktop\\prime_no_read.txt";
        String outputFilePath = "C:\\Users\\computer lab\\OneDrive\\Desktop\\Write_prime_no.txt";

        try (
                // Create BufferedReader to read from file
                BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
                // Create BufferedWriter to write to file
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    // Parse the line into an integer
                    int number = Integer.parseInt(line.trim());
                    // Check if the number is prime
                    if (isPrime(number)) {
                        // Write the prime number to the output file
                        writer.write(String.valueOf(number));
                        writer.newLine(); // Add a new line
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Skipping invalid number: " + line);
                }
            }
            System.out.println("Prime numbers written to " + outputFilePath);
        } catch (IOException e) {
            System.err.println("Error occurred: " + e.getMessage());
        }
    }

    // Method to check if a number is prime
    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}
