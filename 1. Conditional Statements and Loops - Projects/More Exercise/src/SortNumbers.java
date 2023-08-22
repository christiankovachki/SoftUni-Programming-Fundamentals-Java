import java.util.Scanner;
public class SortNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int biggestNumber = Integer.MIN_VALUE;
        int smallestNumber = Integer.MAX_VALUE;
        int middleNumber = 0;

        for (int i = 1; i <= 3; i++) {
            int number = Integer.parseInt(scanner.nextLine());

            if (number > biggestNumber) {
                if (i != 1) {
                    middleNumber = biggestNumber;
                }
                biggestNumber = number;
            }

            if (smallestNumber > number) {
                smallestNumber = number;
            }

            if (biggestNumber == smallestNumber && number == biggestNumber) {
                middleNumber = number;
            }
        }
        System.out.println(biggestNumber);
        System.out.println(middleNumber);
        System.out.println(smallestNumber);
    }
}