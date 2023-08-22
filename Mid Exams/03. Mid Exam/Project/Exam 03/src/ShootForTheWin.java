import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShootForTheWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> sequence = new ArrayList<>(Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList()));

        int shotTargets = 0;

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            int index = Integer.parseInt(input);

            if (index >= sequence.size()) {
                input = scanner.nextLine();
                continue;
            } else {
                for (int i = 0; i < sequence.size(); i++) {
                    if (sequence.get(i) != -1) {
                        reduceOrIncrease(sequence, index);
                        sequence.set(index, -1);
                        shotTargets++;
                        break;
                    }
                }
            }

            input = scanner.nextLine();
        }

        System.out.printf("Shot targets: %d -> ", shotTargets);
        for (int target : sequence) {
            System.out.print(target + " ");
        }
    }

    private static void reduceOrIncrease(List<Integer> sequence, int index) {
        int number = sequence.get(index);
        for (int i = 0; i < sequence.size(); i++) {
            if (i == index || sequence.get(i) == -1) {
                continue;
            }

            if (number < sequence.get(i)) {
                sequence.set(i, sequence.get(i) - number);
            } else if (number >= sequence.get(i)) {
                sequence.set(i, sequence.get(i) + number);
            }
        }
    }
}