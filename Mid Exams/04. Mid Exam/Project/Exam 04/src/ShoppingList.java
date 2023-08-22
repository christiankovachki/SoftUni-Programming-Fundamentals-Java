import java.util.*;
import java.util.stream.Collectors;

public class ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> groceriesList = new ArrayList<>(Arrays.stream(scanner.nextLine().split("!")).collect(Collectors.toList()));

        String input = scanner.nextLine();
        while (!input.equals("Go Shopping!")) {
            String[] arr = input.split(" ");
            String command = arr[0];

            if (command.equals("Urgent")) {
                String item = arr[1];
                if (groceriesList.contains(item)) {
                    input = scanner.nextLine();
                    continue;
                } else {
                    groceriesList.add(0, item);
                }
            } else if (command.equals("Unnecessary")) {
                String item = arr[1];
                if (groceriesList.contains(item)) {
                    groceriesList.remove(item);
                } else {
                    input = scanner.nextLine();
                    continue;
                }
            } else if (command.equals("Correct")) {
                String oldItem = arr[1];
                String newItem = arr[2];
                if (groceriesList.contains(oldItem)) {
                    int index = groceriesList.indexOf(oldItem);
                    groceriesList.set(index, newItem);
                }
            } else if (command.equals("Rearrange")) {
                String item = arr[1];
                if (groceriesList.contains(item)) {
                    groceriesList.remove(item);
                    groceriesList.add(groceriesList.size(), item);
                }
            }

            input = scanner.nextLine();
        }

        System.out.println(String.join(", ", groceriesList));
    }
}