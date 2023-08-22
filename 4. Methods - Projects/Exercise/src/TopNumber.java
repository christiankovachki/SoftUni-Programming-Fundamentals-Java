import java.util.Scanner;
public class TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        getTopNumber(number);
    }

    public static void getTopNumber(int number) {
        for (int i = 1; i <= number; i++) {
            boolean oddDigitPresence = findPresenceOfOddDigit(i);
            int numberToCheck = i;
            int sum = 0;

            while (numberToCheck != 0) {
                int digit = numberToCheck % 10;
                sum += digit;
                numberToCheck = numberToCheck / 10;
            }

            if (sum % 8 == 0 && oddDigitPresence) {
                System.out.println(i);
            }
        }
    }

    public static boolean findPresenceOfOddDigit(int number) {
        while (number != 0) {
            int digit = number % 10;
            if (digit % 2 != 0) {
                return true;
            }

            number = number / 10;
        }

        return false;
    }

}