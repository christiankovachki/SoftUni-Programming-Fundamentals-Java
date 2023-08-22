import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, ArrayList<String>> collection = new LinkedHashMap<>();

        addingInitialPieces(scanner, collection);

        String input = scanner.nextLine();
        while (!input.equals("Stop")) {
            String[] command = input.split("\\|");

            if (command[0].equals("Add")) {
                addingPieces(collection, command);
            } else if (command[0].equals("Remove")) {
                removingPieces(collection, command);
            } else if (command[0].equals("ChangeKey")) {
                changingKey(collection, command);
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, ArrayList<String>> entry : collection.entrySet()) {
            System.out.printf("%s -> Composer: %s, Key: %s\n",
                    entry.getKey(),
                    entry.getValue().get(0),
                    entry.getValue().get(1));
        }

    }

    public static void changingKey(LinkedHashMap<String, ArrayList<String>> collection, String[] command) {
        if (collection.containsKey(command[1])) {
            collection.get(command[1]).set(1, command[2]);
            System.out.printf("Changed the key of %s to %s!\n", command[1], command[2]);
        } else {
            System.out.printf("Invalid operation! %s does not exist in the collection.\n", command[1]);
        }
    }

    public static void removingPieces(LinkedHashMap<String, ArrayList<String>> collection, String[] command) {
        if (collection.containsKey(command[1])) {
            collection.remove(command[1]);
            System.out.printf("Successfully removed %s!\n", command[1]);
        } else {
            System.out.printf("Invalid operation! %s does not exist in the collection.\n", command[1]);
        }
    }

    public static void addingPieces(LinkedHashMap<String, ArrayList<String>> collection, String[] command) {
        if (collection.containsKey(command[1])) {
            System.out.printf("%s is already in the collection!\n", command[1]);
        } else {
            collection.put(command[1], new ArrayList<>());
            collection.get(command[1]).add(command[2]);
            collection.get(command[1]).add(command[3]);
            System.out.printf("%s by %s in %s added to the collection!\n", command[1], command[2], command[3]);
        }
    }

    public static void addingInitialPieces(Scanner scanner, LinkedHashMap<String, ArrayList<String>> collection) {
        int numberOfPieces = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfPieces; i++) {
            String[] input = scanner.nextLine().split("\\|");

            if (collection.containsKey(input[0])) {
                System.out.printf("%s is already in the collection!\n", input[0]);
            } else {
                collection.put(input[0], new ArrayList<>());
                collection.get(input[0]).add(input[1]);
                collection.get(input[0]).add(input[2]);
            }
        }
    }
}