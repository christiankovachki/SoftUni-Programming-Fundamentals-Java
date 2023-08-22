import java.util.Scanner;

public class NumberInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] rangeInput = scanner.nextLine().split(" ");
        int startIndex = Integer.parseInt(rangeInput[0]);
        int endIndex = Integer.parseInt(rangeInput[1]);

        System.out.printf("Range: [%d...%d]\n", startIndex, endIndex);

        String input = scanner.nextLine();

        boolean isValidInteger = checkRange(input, startIndex, endIndex);
        while (!isValidInteger) {
            input = scanner.nextLine();
            isValidInteger = checkRange(input, startIndex, endIndex);
        }
    }

    private static boolean checkRange(String input, int startIndex, int endIndex) {
        try {
            int number = Integer.parseInt(input);
            if (number >= startIndex && number <= endIndex) {
                System.out.printf("Valid number: %d", number);
                return true;
            } else {
                System.out.printf("Invalid number: %d\n", number);
            }
        } catch (NumberFormatException nfe) {
            System.out.printf("Invalid number: %s\n", input);
        }

        return false;
    }
}