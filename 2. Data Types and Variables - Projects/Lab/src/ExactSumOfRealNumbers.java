import java.math.BigDecimal;
import java.util.Scanner;
public class ExactSumOfRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numbersCount = Integer.parseInt(scanner.nextLine());

        BigDecimal sum = new BigDecimal(0);

        for (int i = 0; i < numbersCount; i++) {
            BigDecimal inputNumber = new BigDecimal(scanner.nextLine());

            sum = sum.add(inputNumber);
        }

        System.out.println(sum);
    }
}