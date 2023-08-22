import java.util.*;
import java.util.stream.Collectors;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> treasureChest = new ArrayList<>(Arrays.stream(scanner.nextLine().split("\\|")).collect(Collectors.toList()));

        List<String> stolenItems = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("Yohoho!")) {
            String[] token = input.split(" ");
            String command = token[0];

            if (command.equals("Loot")) {
                for (int i = 1; i < token.length; i++) {
                    if (!treasureChest.contains(token[i])) {
                        treasureChest.add(0, token[i]);
                    }
                }
            } else if (command.equals("Drop")) {
                int index = Integer.parseInt(token[1]);
                if (index >= 0 && index < treasureChest.size()) {
                    treasureChest.add(treasureChest.size(), treasureChest.get(index));
                    treasureChest.remove(index);
                }
            } else if (command.equals("Steal")) {
                int count = Integer.parseInt(token[1]);
                if (treasureChest.size() > 0) {
                    int end = treasureChest.size() - count;
                    for (int i = treasureChest.size() - 1; i >= end; i--) {
                        if (i < 0) {
                            break;
                        }
                        String stolenItem = treasureChest.get(i);
                        stolenItems.add(stolenItem);
                        treasureChest.remove(stolenItem);
                    }

                    if (!stolenItems.isEmpty()) {
                        Collections.reverse(stolenItems);
                        String joined = String.join(", ", stolenItems);
                        System.out.println(joined);
                    }
                }

                stolenItems.clear();
            }

            input = scanner.nextLine();
        }

        if (treasureChest.isEmpty()) {
            System.out.println("Failed treasure hunt.");
        } else {
            int sum = 0;
            for (int i = 0; i < treasureChest.size(); i++) {
                String item = treasureChest.get(i);
                int length = item.length();
                sum += length;
            }

            double averageTreasureGain = sum * 1.0 / treasureChest.size();
            System.out.printf("Average treasure gain: %.2f pirate credits.\n", averageTreasureGain);
        }
    }
}