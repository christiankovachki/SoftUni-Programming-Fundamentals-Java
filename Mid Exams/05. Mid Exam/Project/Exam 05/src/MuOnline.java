import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> dungeonsRooms = new ArrayList<>(Arrays.stream(scanner.nextLine().split("\\|")).collect(Collectors.toList()));

        int health = 100;
        int bitcoins = 0;
        boolean isAlive = true;

        for (int i = 0; i < dungeonsRooms.size(); i++) {
            String[] arr = dungeonsRooms.get(i).split(" ");
            String command = arr[0];
            int number = Integer.parseInt(arr[1]);

            if (command.equals("potion")) {
                if (health + number > 100) {
                    number = 100 - health;
                    health = 100;
                } else {
                    health += number;
                }

                System.out.printf("You healed for %d hp.\n", number);
                System.out.printf("Current health: %d hp.\n", health);
            } else if (command.equals("chest")) {
                bitcoins += number;
                System.out.printf("You found %d bitcoins.\n", number);
            } else {
                health -= number;
                if (health <= 0) {
                    System.out.printf("You died! Killed by %s.\n", command);
                    System.out.printf("Best room: %s\n", i + 1);
                    isAlive = false;
                    break;
                } else {
                    System.out.printf("You slayed %s.\n", command);
                }
            }
        }

        if (isAlive) {
            System.out.println("You've made it!");
            System.out.printf("Bitcoins: %d\n", bitcoins);
            System.out.printf("Health: %d\n", health);
        }
    }
}