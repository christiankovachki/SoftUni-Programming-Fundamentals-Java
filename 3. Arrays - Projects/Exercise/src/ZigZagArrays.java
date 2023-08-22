import java.util.Arrays;
import java.util.Scanner;
public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfLines = Integer.parseInt(scanner.nextLine());

        int[] firstArray = new int[numberOfLines];
        int[] secondArray = new int[numberOfLines];
        for (int i = 0; i < numberOfLines; i++) {
            int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
            if (i % 2 == 0) {
                firstArray[i] = input[0];
                secondArray[i] = input[1];
            } else {
                firstArray[i] = input[1];
                secondArray[i] = input[0];
            }
        }

        for (int i = 0; i < firstArray.length; i++) {
            System.out.printf("%d ", firstArray[i]);
        }
        System.out.println();

        for (int i = 0; i < secondArray.length; i++) {
            System.out.printf("%d ", secondArray[i]);
        }
        System.out.println();

    }
}