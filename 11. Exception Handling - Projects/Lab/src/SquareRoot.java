import java.util.Scanner;

public class SquareRoot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            int number = Integer.parseInt(scanner.nextLine());

            if (number < 1) {
                System.out.println("Invalid");
            } else {
                double result = Math.sqrt(number);
                System.out.printf("%.2f\n", result);
            }
        } catch (NumberFormatException ex) {
            System.out.println("Invalid");
        } finally {
            System.out.println("Goodbye");
        }
    }
}