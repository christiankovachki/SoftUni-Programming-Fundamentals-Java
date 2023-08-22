import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
public class MinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Integer> quantitiesOfResources = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("stop")) {
            int quantity = Integer.parseInt(scanner.nextLine());

            if (quantitiesOfResources.containsKey(input)) {
                quantitiesOfResources.put(input, quantitiesOfResources.get(input) + quantity);
            } else {
                quantitiesOfResources.put(input, quantity);
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, Integer> entry : quantitiesOfResources.entrySet()) {
            System.out.printf("%s -> %d\n", entry.getKey(), entry.getValue());
        }

    }
}