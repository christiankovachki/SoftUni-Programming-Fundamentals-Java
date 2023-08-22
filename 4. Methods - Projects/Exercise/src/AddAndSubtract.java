import java.util.Scanner;
public class AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());
        int thirdNumber = Integer.parseInt(scanner.nextLine());

        int resultOfSum = sumOfFirstTwoNumbers(firstNumber, secondNumber);
        subtractThirdNumber(thirdNumber, resultOfSum);
    }

    public static int sumOfFirstTwoNumbers(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

    public static void subtractThirdNumber(int thirdNumber, int resultOfSum) {
        System.out.printf("%d \n", resultOfSum - thirdNumber);
    }
}