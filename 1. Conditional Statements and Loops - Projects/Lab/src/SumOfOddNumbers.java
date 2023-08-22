import java.util.Scanner;
public class SumOfOddNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        int oddNumber = 1;
        int sum = 0;

        for (int i = 0; i < number; i++) {

            System.out.println(oddNumber);
            sum += oddNumber;

            oddNumber += 2;
        }

        System.out.printf("Sum: %d", sum);
    }
}