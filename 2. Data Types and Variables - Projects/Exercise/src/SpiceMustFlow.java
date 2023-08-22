import java.util.Scanner;
public class SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startingYield = Integer.parseInt(scanner.nextLine());

        int daysCounter = 0;
        int consumedSpicesFromCrew = 0;

        int yield = startingYield;
        while (yield >= 100) {
            daysCounter++;
            consumedSpicesFromCrew += yield - 26;
            yield -= 10;
        }

        int totalConsumedSpice = consumedSpicesFromCrew - 26;
        if (totalConsumedSpice < 0) {
            totalConsumedSpice = 0;
        }
        System.out.println(daysCounter);
        System.out.println(totalConsumedSpice);
    }
}