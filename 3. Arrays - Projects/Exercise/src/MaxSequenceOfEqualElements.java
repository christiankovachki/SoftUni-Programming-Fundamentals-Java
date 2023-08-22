import java.util.Arrays;
import java.util.Scanner;
public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(value -> Integer.parseInt(value)).toArray();

        int biggestSequenceCounter = 0;
        int biggestSequenceNumber = 0;
        int sequenceCounter = 1;

        for (int i = 0; i < numbers.length - 1; i++) {

            if (numbers[i] == numbers[i + 1]) {
                sequenceCounter++;
                if (sequenceCounter > biggestSequenceCounter) {
                    biggestSequenceNumber = numbers[i];
                    biggestSequenceCounter = sequenceCounter;
                }
            } else {
                if (sequenceCounter > biggestSequenceCounter) {
                    biggestSequenceCounter = sequenceCounter;
                }
                sequenceCounter = 1;
            }
        }

        for (int i = 0; i < biggestSequenceCounter; i++) {
            System.out.print(biggestSequenceNumber + " ");
        }
        System.out.println();
    }
}