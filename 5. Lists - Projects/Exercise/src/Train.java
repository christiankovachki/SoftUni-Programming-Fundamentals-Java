import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numberOfPassengers = new ArrayList<>(Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList()));
        int maxCapacity = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] typeOfInput = input.split(" ");

            if (typeOfInput.length == 2) {
                int addPassengers = Integer.parseInt(typeOfInput[1]);
                numberOfPassengers.add(addPassengers);
            } else if (typeOfInput.length == 1) {
                int addPassengers = Integer.parseInt(typeOfInput[0]);

                for (int i = 0; i < numberOfPassengers.size(); i++) {
                    if (numberOfPassengers.get(i) <= maxCapacity) {
                        int totalPassengers = numberOfPassengers.get(i) + addPassengers;
                        if (totalPassengers <= maxCapacity) {
                            numberOfPassengers.set(i, totalPassengers);
                            break;
                        }
                    }
                }
            }

            input = scanner.nextLine();
        }

        for (int numberOfPassenger : numberOfPassengers) {
            System.out.print(numberOfPassenger + " ");
        }

        System.out.println();
    }
}