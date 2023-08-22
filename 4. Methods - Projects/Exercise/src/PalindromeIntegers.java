import java.util.Arrays;
import java.util.Scanner;
public class PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            System.out.println(checkIfNumberIsPalindrome(input));

            input = scanner.nextLine();
        }
    }

    public static boolean checkIfNumberIsPalindrome(String number) {
        String[] numberAsArr = number.split("");
        String[] reversed = new String[numberAsArr.length];

        int j = 0;
        for (int i = numberAsArr.length - 1; i >= 0; i--) {
            reversed[j] = numberAsArr[i];
            j++;
            if (j == numberAsArr.length) {
                break;
            }
        }

        return Arrays.equals(numberAsArr, reversed);
    }

}