import java.util.Scanner;

public class SquareNumber {
    // Method to calculate the square of a number
    public static int square(int number) {
        return number * number;
    }

    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Ask the user for a number
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();

        // Calculate the square of the number
        int result = square(num);

        // Output the result
        System.out.println("The square of " + num + " is: " + result);

        // Close the scanner
        scanner.close();
    }
}
