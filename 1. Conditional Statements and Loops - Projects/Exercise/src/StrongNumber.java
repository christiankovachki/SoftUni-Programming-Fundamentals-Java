import java.util.Scanner;
public class StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        int sumOfFactorials = 0;

        String numberAsString = String.valueOf(number);
        for (int i = 0; i < numberAsString.length(); i++) {
            int digit = Integer.parseInt(String.valueOf(numberAsString.charAt(i)));
            int factorial = 1;

            for (int j = 1; j <= digit; j++) {
                factorial = factorial * j;
            }

            sumOfFactorials += factorial;
        }

        if (sumOfFactorials == number) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

    }
}