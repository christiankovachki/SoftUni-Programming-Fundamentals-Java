import java.util.Scanner;
public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] loot = scanner.nextLine().split("\\|");

        String input = scanner.nextLine();
        while (!input.equals("Yohoho!")) {
            String[] command = input.split("\\s+");
            String token = command[0];

            switch (token) {
                case "Loot":
                    String[] items = new String[command.length - 1];
                    for (int i = 1; i <= items.length; i++) {
                        items[i - 1] = command[i];
                    }

                    int repetitiveItems = 0;
                    for (int i = 0; i < items.length; i++) {
                        String newItemName = items[i];
                        for (int j = 0; j < loot.length; j++) {
                            String itemName = loot[j];

                            if (itemName.equals(newItemName)) {
                                repetitiveItems++;
                                items[i] = null;
                                break;
                            }
                        }
                    }

                    String[] newestLoot = new String[loot.length + (items.length - repetitiveItems)];
                    for (int i = 0; i < newestLoot.length; i++) {
                        if (items[i] == null) {
                            i = i - 1;
                        }
                       newestLoot[i] = items[items.length - 1 - i];
                    }

                    break;
                case "Drop":

                    break;
                case "Steal":

                    break;
            }

            input = scanner.nextLine();
        }
    }
}