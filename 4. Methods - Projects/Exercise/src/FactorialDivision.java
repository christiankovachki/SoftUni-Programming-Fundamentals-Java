import java.util.Scanner;
public class FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());

        double factorialDiv = getFactorial(firstNumber) * 1.0 / getFactorial(secondNumber);
        System.out.printf("%.2f", factorialDiv);
    }

    public static long getFactorial(int number) {
        long fact = 1;
        for (int i = 2; i <= number; i++) {
            fact = fact * i;
        }

        return fact;
    }
}