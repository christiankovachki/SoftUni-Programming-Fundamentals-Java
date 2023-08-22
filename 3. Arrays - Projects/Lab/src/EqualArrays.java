import java.util.Scanner;
public class EqualArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstInput = scanner.nextLine().split(" ");
        String[] secondInput = scanner.nextLine().split(" ");

        int[] firstArray = new int[firstInput.length];
        for (int i = 0; i < firstArray.length; i++) {
            firstArray[i] = Integer.parseInt(firstInput[i]);
        }

        int[] secondArray = new int[secondInput.length];
        for (int i = 0; i < secondArray.length; i++) {
            secondArray[i] = Integer.parseInt(secondInput[i]);
        }

        int sum = 0;
        for (int i = 0; i < firstArray.length; i++) {
            if (firstArray[i] == secondArray[i]) {
                sum += firstArray[i];
                if (i == firstArray.length - 1) {
                    System.out.printf("Arrays are identical. Sum: %d", sum);
                }
            } else {
                System.out.printf("Arrays are not identical. Found difference at %d index.", i);
                break;
            }
        }

    }
}