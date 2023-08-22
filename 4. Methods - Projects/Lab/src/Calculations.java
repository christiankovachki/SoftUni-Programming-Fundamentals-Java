import java.util.Scanner;
public class Calculations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String action = scanner.nextLine();

        switch (action) {
            case "add":
                adding(scanner.nextInt(), scanner.nextInt());
                break;
            case "multiply":
                multiply(scanner.nextInt(), scanner.nextInt());
                break;
            case "subtract":
                subtract(scanner.nextInt(), scanner.nextInt());
                break;
            case "divide":
                divide(scanner.nextInt(), scanner.nextInt());
                break;
        }

    }

    public static void adding(int firstNumber, int secondNumber) {
        int result = firstNumber + secondNumber;
        System.out.println(result);
    }

    public static void multiply(int firstNumber, int secondNumber) {
        int result = firstNumber * secondNumber;
        System.out.println(result);
    }

    public static void subtract(int firstNumber, int secondNumber) {
        int result = firstNumber - secondNumber;
        System.out.println(result);
    }

    public static void divide(int firstNumber, int secondNumber) {
        int result = firstNumber / secondNumber;
        System.out.println(result);
    }
}