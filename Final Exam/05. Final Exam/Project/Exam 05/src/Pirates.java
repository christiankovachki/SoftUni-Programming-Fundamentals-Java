import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, ArrayList<Integer>> targetedCities = new LinkedHashMap<>();

        addingTargetedCities(scanner, targetedCities);

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] event = input.split("=>");
            
            if (event[0].equals("Plunder")) {
                plunderingCities(targetedCities, event);
            } else if (event[0].equals("Prosper")) {
                prosperingCities(targetedCities, event);
            }

            input = scanner.nextLine();
        }

        if (targetedCities.isEmpty()) {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!\n");
        } else {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:\n", targetedCities.size());
            for (Map.Entry<String, ArrayList<Integer>> entry : targetedCities.entrySet()) {
                System.out.printf("%s -> Population: %d citizens, Gold: %d kg\n",
                        entry.getKey(), entry.getValue().get(0), entry.getValue().get(1));
            }
        }
    }

    public static void prosperingCities(LinkedHashMap<String, ArrayList<Integer>> targetedCities, String[] event) {
        String town = event[1];
        int gold = Integer.parseInt(event[2]);

        if (gold < 0) {
            System.out.println("Gold added cannot be a negative number!");
        } else {
            int currentGold = targetedCities.get(town).get(1);
            currentGold += gold;
            targetedCities.get(town).set(1, currentGold);
            System.out.printf("%d gold added to the city treasury. %s now has %d gold.\n",
                    gold, town, currentGold);
        }
    }

    public static void plunderingCities(LinkedHashMap<String, ArrayList<Integer>> targetedCities, String[] event) {
        String town = event[1];
        int people = Integer.parseInt(event[2]);
        int gold = Integer.parseInt(event[3]);

        System.out.printf("%s plundered! %d gold stolen, %d citizens killed.\n", town, gold, people);

        int currentPopulation = targetedCities.get(town).get(0);
        currentPopulation -= people;
        targetedCities.get(town).set(0, currentPopulation);

        int currentGold = targetedCities.get(town).get(1);
        currentGold -= gold;
        targetedCities.get(town).set(1, currentGold);

        if (currentPopulation <= 0 || currentGold <= 0) {
            targetedCities.remove(town);
            System.out.printf("%s has been wiped off the map!\n", town);
        }
    }

    public static void addingTargetedCities(Scanner scanner, LinkedHashMap<String, ArrayList<Integer>> targetedCities) {
        String input = scanner.nextLine();
        while (!input.equals("Sail")) {
            String[] targets = input.split("\\|\\|");

            if (targetedCities.containsKey(targets[0])) {
                int currentPopulation = targetedCities.get(targets[0]).get(0);
                int currentGold = targetedCities.get(targets[0]).get(1);
                targetedCities.get(targets[0]).set(0, currentPopulation + Integer.parseInt(targets[1]));
                targetedCities.get(targets[0]).set(1, currentGold + Integer.parseInt(targets[2]));
            } else {
                targetedCities.put(targets[0], new ArrayList<>());
                targetedCities.get(targets[0]).add(Integer.parseInt(targets[1]));
                targetedCities.get(targets[0]).add(Integer.parseInt(targets[2]));
            }

            input = scanner.nextLine();
        }
    }
}