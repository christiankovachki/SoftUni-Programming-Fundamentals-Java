import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MemoryGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> sequence = new ArrayList<>(Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList()));

        int movesCounter = 0;

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] arr = input.split(" ");
            int firstIndex = Integer.parseInt(arr[0]);
            int secondIndex = Integer.parseInt(arr[1]);
            movesCounter++;

            if (!checkIfIndexesAreValid(sequence, firstIndex, secondIndex)) {
                getPunishmentForCheating(sequence, movesCounter);
            } else {
                String firstElement = sequence.get(firstIndex);
                String secondElement = sequence.get(secondIndex);
                if (firstElement.equals(secondElement)) {
                    System.out.printf("Congrats! You have found matching elements - %s!\n", firstElement);
                    sequence.remove(firstElement);
                    sequence.remove(secondElement);
                } else {
                    System.out.println("Try again!");
                }
            }

            if (sequence.isEmpty()) {
                System.out.printf("You have won in %d turns!\n", movesCounter);
                break;
            }

            input = scanner.nextLine();
        }

        if (input.equals("end")) {
            System.out.println("Sorry you lose :(");
        }

        for (String state : sequence) {
            System.out.print(state + " ");
        }
        System.out.println();

    }

    public static void getPunishmentForCheating(List<String> sequence, int movesCounter) {
        System.out.println("Invalid input! Adding additional elements to the board");

        int index = sequence.size() / 2;
        String addElement = -movesCounter + "a";

        sequence.add(index, addElement);
        sequence.add(index + 1, addElement);
    }

    public static boolean checkIfIndexesAreValid(List<String> sequence, int firstIndex, int secondIndex) {
        if (firstIndex == secondIndex) {
            return false;
        } else if (firstIndex < 0 || firstIndex > sequence.size() - 1) {
            return false;
        } else if (secondIndex < 0 || secondIndex > sequence.size() - 1) {
            return false;
        }

        return true;
    }
}