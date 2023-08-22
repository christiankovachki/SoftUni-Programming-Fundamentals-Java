import java.util.Scanner;
public class MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = scanner.nextInt();
        char operator = scanner.next().charAt(0);
        int secondNumber = scanner.nextInt();

        switch (operator) {
            case '+':
                System.out.println(addingOfTwoIntegers(firstNumber, secondNumber));
                break;
            case '-':
                System.out.println(subtractingOfTwoIntegers(firstNumber, secondNumber));
                break;
            case '*':
                System.out.println(multiplicationOfTwoIntegers(firstNumber, secondNumber));
                break;
            case '/':
                System.out.println(divisionOfTwoIntegers(firstNumber, secondNumber));
                break;
        }
    }

    public static int addingOfTwoIntegers(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

    public static int subtractingOfTwoIntegers(int firstNumber, int secondNumber) {
        return firstNumber - secondNumber;
    }

    public static int multiplicationOfTwoIntegers(int firstNumber, int secondNumber) {
        return firstNumber * secondNumber;
    }

    public static int divisionOfTwoIntegers(int firstNumber, int secondNumber) {
        return firstNumber / secondNumber;
    }
}