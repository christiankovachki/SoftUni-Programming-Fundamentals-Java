import java.util.Arrays;
import java.util.Scanner;
public class ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbersArray = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        int numberOfRotations = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfRotations; i++) {
            int temp = numbersArray[0];
            for (int j = 0; j < numbersArray.length - 1; j++) {
                numbersArray[j] = numbersArray[j + 1];
            }
            numbersArray[numbersArray.length - 1] = temp;
        }

        for (int i = 0; i < numbersArray.length; i++) {
            System.out.print(numbersArray[i] + " ");
        }
    }
}