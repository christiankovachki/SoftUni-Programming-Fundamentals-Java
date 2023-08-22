import java.util.Scanner;
public class BlackFlag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int daysOfPlundering = Integer.parseInt(scanner.nextLine());
        int dailyPlunder = Integer.parseInt(scanner.nextLine());
        double expectedPlunder = Double.parseDouble(scanner.nextLine());

        double totalPlunder = 0;
        for (int day = 1; day <= daysOfPlundering; day++) {
            totalPlunder += dailyPlunder;

            if (day % 3 == 0) {
                totalPlunder += dailyPlunder * 0.5;
            }

            if (day % 5 == 0) {
                totalPlunder = totalPlunder - (totalPlunder * 0.3);
            }
        }

        if (totalPlunder >= expectedPlunder) {
            System.out.printf("Ahoy! %.2f plunder gained.\n", totalPlunder);
        } else {
            double percentage = totalPlunder / expectedPlunder * 100;
            System.out.printf("Collected only %.2f%% of the plunder.\n", percentage);
        }
    }
}