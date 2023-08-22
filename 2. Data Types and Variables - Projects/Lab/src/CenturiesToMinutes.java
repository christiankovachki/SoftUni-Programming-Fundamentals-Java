import java.util.Scanner;
public class CenturiesToMinutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCenturies = Integer.parseInt(scanner.nextLine());

        double years = numberOfCenturies * 100;
        double days = years * 365.2422;
        double hours = days * 24;
        double minutes = hours * 60;

        System.out.printf("%d centuries = %.0f years = %.0f days = %.0f hours = %.0f minutes\n", numberOfCenturies, years, days, hours, minutes);
    }
}