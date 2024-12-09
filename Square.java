import java.util.Scanner;

public class SquareNumber {
    // Method to calculate the square of a number
    public static int square(int number) {
        return number * number;
    }

    public static void main(String[] args) {
        int num=10;
        int result = square(num);


        System.out.println("The square of " + num + " is: " + result);
    }
}
