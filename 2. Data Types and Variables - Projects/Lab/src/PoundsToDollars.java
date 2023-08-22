import java.util.Scanner;
public class PoundsToDollars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        float pounds = Float.parseFloat(scanner.nextLine());

        System.out.printf("%.3f", pounds * 1.36); // Pounds converted to Dollars
    }
}