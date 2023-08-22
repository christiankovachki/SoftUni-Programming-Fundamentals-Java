import java.util.Scanner;
public class CounterStrike {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int initialEnergy = Integer.parseInt(scanner.nextLine());

        int wonBattles = 0;
        String input = scanner.nextLine();
        while (!input.equals("End of battle")) {
            int distance = Integer.parseInt(input);
            if (initialEnergy < 0 || distance > initialEnergy) {
                System.out.printf("Not enough energy! Game ends with %d won battles and %d energy", wonBattles, initialEnergy);
                break;
            }

            initialEnergy -= distance;
            wonBattles++;
            if (wonBattles % 3 == 0) {
                initialEnergy += wonBattles;
            }

            input = scanner.nextLine();
        }

        if (input.equals("End of battle")) {
            System.out.printf("Won battles: %d. Energy left: %d", wonBattles, initialEnergy);
        }
    }
}