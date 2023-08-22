import java.util.Arrays;
import java.util.Scanner;
public class MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        printMiddleChar(scanner.nextLine());
    }

    public static void printMiddleChar(String input) {
        String[] inputAsStr = input.split("");

        if (inputAsStr.length % 2 == 0) {
            String firstChar = inputAsStr[inputAsStr.length / 2 - 1];
            String secondChar = inputAsStr[inputAsStr.length / 2];

            System.out.println(firstChar + secondChar);
        } else {
            System.out.println(inputAsStr[inputAsStr.length / 2]);
        }
    }
}