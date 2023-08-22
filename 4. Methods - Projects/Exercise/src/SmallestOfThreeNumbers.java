import java.util.Scanner;
public class SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());
        int thirdNumber = Integer.parseInt(scanner.nextLine());

        int smallestBetweenTwoNumbers = getSmallestNumber(firstNumber, secondNumber);
        int smallestNumber = getSmallestNumber(smallestBetweenTwoNumbers, thirdNumber);

        System.out.println(smallestNumber);
    }

    public static int getSmallestNumber(int firstNumber, int secondNumber) {
        if (firstNumber < secondNumber) {
            return firstNumber;
        }

        return secondNumber;
    }
}