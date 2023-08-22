import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TheLift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int queueOfPeople = Integer.parseInt(scanner.nextLine());
        List<Integer> currentStateOfLift = new ArrayList<>(Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList()));

        boolean noMoreSpots = false;
        boolean hasEmptySpots = false;

        while (queueOfPeople > 0) {
            for (int i = 0; i < currentStateOfLift.size(); i++) {
                if (currentStateOfLift.get(i) < 4) {
                    int takenSpots = currentStateOfLift.get(i);
                    int availableSpots = 4 - takenSpots;

                    if (availableSpots > queueOfPeople) {
                        availableSpots = queueOfPeople;
                    }

                    queueOfPeople -= availableSpots;
                    currentStateOfLift.set(i, availableSpots + takenSpots);
                }

                if (i == currentStateOfLift.size() - 1 && queueOfPeople > 0) {
                    noMoreSpots = true;
                    break;
                }
            }

            if (noMoreSpots) {
                break;
            }
        }

        for (int people : currentStateOfLift) {
            if (people < 4) {
                hasEmptySpots = true;
                break;
            }
        }

        if (hasEmptySpots) {
            System.out.println("The lift has empty spots!");
        } else if (noMoreSpots) {
            System.out.printf("There isn't enough space! %d people in a queue!\n", queueOfPeople);
        }

        for (int spot : currentStateOfLift) {
            System.out.print(spot + " ");
        }

        System.out.println();
    }
}