import java.util.Scanner;
public class FromLeftToTheRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            long leftNumber = Long.parseLong(scanner.next());
            long rightNumber = Long.parseLong(scanner.next());

            if (leftNumber > rightNumber) {
                long number = leftNumber;
                int sum = 0;
                for (int j = 0; j < String.valueOf(leftNumber).length(); j++) {
                    long digit = number % 10;
                    sum += digit;
                    number /= 10;
                }
                System.out.println(Math.abs(sum));
            } else {
                long number = rightNumber;
                int sum = 0;
                for (int j = 0; j < String.valueOf(rightNumber).length(); j++) {
                    long digit = number % 10;
                    sum += digit;
                    number /= 10;
                }
                System.out.println(Math.abs(sum));
            }
        }
    }
}