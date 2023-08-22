import java.util.*;

public class PlantDiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Integer> plantsRarity = new LinkedHashMap<>();
        LinkedHashMap<String, ArrayList<Double>> plantsRating = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("<->");

            if (plantsRarity.containsKey(input[0])) {
                plantsRarity.replace(input[0], Integer.parseInt(input[1]));
            } else {
                plantsRarity.put(input[0], Integer.parseInt(input[1]));
                plantsRating.put(input[0], new ArrayList<>());
            }
        }

        String input = scanner.nextLine();
        while (!input.equals("Exhibition")) {
            String[] command = input.split(": ");

            if (command[0].equals("Rate")) {
                String[] plantRating = command[1].split(" - ");
                //plantRating[0] - plantName
                //plantRating[1] - plantRating
                if (plantsRarity.containsKey(plantRating[0])) {
                    plantsRating.get(plantRating[0]).add(Double.parseDouble(plantRating[1]));
                } else {
                    System.out.println("error");
                }
            } else if (command[0].equals("Update")) {
                String[] plantRarity = command[1].split(" - ");
                //plantRarity[0] - plantName
                //plantRarity[1] - plantRarity
                if (plantsRarity.containsKey(plantRarity[0])) {
                    plantsRarity.replace(plantRarity[0], Integer.parseInt(plantRarity[1]));
                } else {
                    System.out.println("error");
                }
            } else if (command[0].equals("Reset")) {
                if (plantsRating.containsKey(command[1])) {
                    plantsRating.get(command[1]).clear();
                    plantsRating.get(command[1]).add(0.0);
                } else {
                    System.out.println("error");
                }
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, ArrayList<Double>> entry : plantsRating.entrySet()) {
            double avg = entry.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble();
            entry.getValue().clear();
            entry.getValue().add(avg);
        }

        System.out.println("Plants for the exhibition:");
        for (Map.Entry<String, Integer> entry : plantsRarity.entrySet()) {
            System.out.printf("- %s; Rarity: %d; ", entry.getKey(), entry.getValue());
            System.out.printf("Rating: %.2f\n", plantsRating.get(entry.getKey()).get(0));
        }

    }
}