import java.util.Scanner;
public class MultiplicationSign {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());
        int thirdNumber = Integer.parseInt(scanner.nextLine());

        int multiplOfFirstTwo = multiplication(firstNumber, secondNumber);
        int finalProduct = multiplication(multiplOfFirstTwo, thirdNumber);

        getMultiplicationSign(finalProduct);
    }

    public static int multiplication(int firstNumber, int secondNumber) {
        return firstNumber * secondNumber;
    }

    public static void getMultiplicationSign(int product) {
        if (product < 0) {
            System.out.println("negative");
        } else if (product > 0) {
            System.out.println("positive");
        } else {
            System.out.println("zero");
        }
    }
}