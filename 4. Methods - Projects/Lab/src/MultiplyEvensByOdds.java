import java.util.Scanner;
public class MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numbers = Integer.parseInt(scanner.nextLine());

        int absNumbers = Math.abs(numbers);

        System.out.println(multiplicationOfEvensAndOdds(absNumbers));

    }

    public static int multiplicationOfEvensAndOdds(int numbers) {
        int evenSum = sumOfEvenDigits(numbers);
        int oddSum = sumOfOddDigits(numbers);

        return evenSum * oddSum;
    }

    public static int sumOfEvenDigits (int numbers) {
        int evenSum = 0;

        while (numbers != 0) {
            int digit = numbers % 10;
            if (digit % 2 == 0) {
                evenSum += digit;
            }

            numbers = numbers / 10;
        }

        return evenSum;
    }

    public static int sumOfOddDigits (int numbers) {
        int oddSum = 0;

        while (numbers != 0) {
            int digit = numbers % 10;
            if (digit % 2 != 0) {
                oddSum += digit;
            }

            numbers = numbers / 10;
        }

        return oddSum;
    }
}