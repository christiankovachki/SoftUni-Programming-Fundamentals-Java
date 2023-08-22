import java.util.Scanner;
public class SumDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        int sum = 0;
        int currentNumber = number;

        for (int i = 0; i < String.valueOf(number).length(); i++) {
            sum += currentNumber % 10;
            currentNumber = currentNumber / 10;
        }

        System.out.println(sum);
    }
}