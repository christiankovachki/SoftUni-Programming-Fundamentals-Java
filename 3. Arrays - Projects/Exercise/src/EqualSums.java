import java.util.Arrays;
import java.util.Scanner;
public class EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(value -> Integer.parseInt(value)).toArray();

        for (int i = 0; i < numbers.length; i++) {
            int leftSum = 0;
            int rightSum = 0;

            if (i > 0) {
                for (int k = 0; k < i; k++) {
                    leftSum += numbers[k];
                }
            }

            for (int j = i + 1; j < numbers.length; j++) {
                rightSum += numbers[j];
            }

            if (leftSum == rightSum) {
                System.out.printf("%d\n", i);
                break;
            } else if (i == numbers.length - 1) {
                System.out.println("no");
            }
        }
    }
}