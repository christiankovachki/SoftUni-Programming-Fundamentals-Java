import java.util.Scanner;
public class EvenAndOddSubtraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int[] numbers = new int[input.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        int sumEven = 0;
        int sumOdd = 0;
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            if (num % 2 == 0) {
                sumEven += num;
            } else {
                sumOdd += num;
            }
        }

        System.out.println(sumEven - sumOdd);
    }
}