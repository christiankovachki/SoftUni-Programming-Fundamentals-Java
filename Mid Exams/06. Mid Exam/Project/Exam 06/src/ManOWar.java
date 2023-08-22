import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ManOWar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> pirateShipStatus = new ArrayList<>(Arrays.stream(scanner.nextLine().split(">"))
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
        List<Integer> warshipStatus = new ArrayList<>(Arrays.stream(scanner.nextLine().split(">"))
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
        int maxHealth = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();
        while (!input.equals("Retire")) {
            String[] token = input.split(" ");
            String command = token[0];

            if (command.equals("Fire")) {
                int index = Integer.parseInt(token[1]);
                int damage = Integer.parseInt(token[2]);
                if (index >= 0 && index < warshipStatus.size()) {
                    int section = warshipStatus.get(index);
                    section -= damage;
                    if (section <= 0) {
                        System.out.println("You won! The enemy ship has sunken.");
                        return;
                    }

                    warshipStatus.set(index, section);
                }
            } else if (command.equals("Defend")) {
                int startIndex = Integer.parseInt(token[1]);
                int endIndex = Integer.parseInt(token[2]);
                int damage = Integer.parseInt(token[3]);
                if (startIndex >= 0 && endIndex < pirateShipStatus.size()) {
                    for (int i = startIndex; i <= endIndex; i++) {
                        int section = pirateShipStatus.get(i);
                        section -= damage;
                        if (section <= 0) {
                            System.out.println("You lost! The pirate ship has sunken.");
                            return;
                        }

                        pirateShipStatus.set(i, section);
                    }
                }
            } else if (command.equals("Repair")) {
                int index = Integer.parseInt(token[1]);
                int health = Integer.parseInt(token[2]);
                if (index >= 0 && index < pirateShipStatus.size()) {
                    int repairHealth = pirateShipStatus.get(index) + health;
                    pirateShipStatus.set(index, Math.min(repairHealth, maxHealth));
                }
            } else if (command.equals("Status")) {
                double sectionsToRepair = maxHealth * 0.2; // Тук имам гранични стойности, може да се счупи нещо
                int count = 0;
                for (int i = 0; i < pirateShipStatus.size(); i++) {
                    int section = pirateShipStatus.get(i);
                    if (section < sectionsToRepair) {
                        count++;
                    }
                }

                System.out.printf("%d sections need repair.\n", count);
            }

            input = scanner.nextLine();
        }

        int pirateShipSum = 0;
        for (int section : pirateShipStatus) {
            pirateShipSum += section;
        }
        System.out.printf("Pirate ship status: %d\n", pirateShipSum);

        int warshipSum = 0;
        for (int section : warshipStatus) {
            warshipSum += section;
        }
        System.out.printf("Warship status: %d\n", warshipSum);
    }
}