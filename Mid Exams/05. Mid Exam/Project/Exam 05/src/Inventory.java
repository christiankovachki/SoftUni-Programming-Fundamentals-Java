import java.util.*;
import java.util.stream.Collectors;

public class Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> journalItems = new ArrayList<>(Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList()));

        String input = scanner.nextLine();
        while (!input.equals("Craft!")) {
            String[] arr = input.split(" - ");
            String command = arr[0];

            if (command.equals("Collect")) {
                String item = arr[1];
                if (journalItems.contains(item)) {
                    input = scanner.nextLine();
                    continue;
                } else {
                    journalItems.add(item);
                }
            } else if (command.equals("Drop")) {
                String item = arr[1];
                if (journalItems.contains(item)) {
                    journalItems.remove(item);
                }
            } else if (command.equals("Combine Items")) {
                String[] split = arr[1].split(":");
                String oldItem = split[0];
                String newItem = split[1];
                if (journalItems.contains(oldItem)) {
                    int index = journalItems.indexOf(oldItem);
                    journalItems.add(index + 1, newItem);
                }
            } else if (command.equals("Renew")) {
                String item = arr[1];
                if (journalItems.contains(item)) {
                    journalItems.remove(item);
                    journalItems.add(journalItems.size(), item);
                }
            }

            input = scanner.nextLine();
        }

        String output = String.join(", ", journalItems);
        System.out.println(output);
    }
}