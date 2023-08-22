import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstPlayer = new ArrayList<>(Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
        List<Integer> secondPlayer = new ArrayList<>(Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList()));

        int sum = 0;
        while (true) {

            for (int i = 0; i < firstPlayer.size(); i++) {
                int firstPLayerCard = firstPlayer.get(0);
                int secondPLayerCard = secondPlayer.get(0);

                if (firstPLayerCard > secondPLayerCard) {
                    firstPlayer.add(firstPlayer.size(), firstPLayerCard);
                    firstPlayer.add(firstPlayer.size(), secondPLayerCard);
                    firstPlayer.remove(0);
                    secondPlayer.remove(0);
                } else if (secondPLayerCard > firstPLayerCard) {
                    secondPlayer.add(secondPlayer.size(), secondPLayerCard);
                    secondPlayer.add(secondPlayer.size(), firstPLayerCard);
                    secondPlayer.remove(0);
                    firstPlayer.remove(0);
                } else {
                    firstPlayer.remove(0);
                    secondPlayer.remove(0);
                }

                if (firstPlayer.isEmpty()) {
                    for (int card : secondPlayer) {
                        sum += card;
                    }
                    System.out.printf("Second player wins! Sum: %d", sum);
                    return;
                } else if (secondPlayer.isEmpty()) {
                    for (int card : firstPlayer) {
                        sum += card;
                    }
                    System.out.printf("First player wins! Sum: %d", sum);
                    return;
                }
            }
        }
    }
}