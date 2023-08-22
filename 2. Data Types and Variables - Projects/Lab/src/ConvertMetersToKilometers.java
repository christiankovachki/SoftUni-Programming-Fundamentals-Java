import java.util.Scanner;
public class ConvertMetersToKilometers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int distanceInMeters = Integer.parseInt(scanner.nextLine());

        System.out.printf("%.2f\n", distanceInMeters / 1000.0);
    }
}