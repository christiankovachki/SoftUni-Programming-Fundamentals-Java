import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HeartDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> neighborhood = new ArrayList<>(Arrays.stream(scanner.nextLine().split("@"))
                .map(Integer::parseInt)
                .collect(Collectors.toList()));

        int index = 0;
        String input = scanner.nextLine();
        while (!input.equals("Love!")) {
            String[] arr = input.split(" ");
            int length = Integer.parseInt(arr[1]);
            index += length;

            if (index >= neighborhood.size()) {
                index = 0;
            }

            if (neighborhood.get(index) == 0) {
                System.out.printf("Place %d already had Valentine's day.\n", index);
            } else {
                neighborhood.set(index, neighborhood.get(index) - 2);
                if (neighborhood.get(index) == 0) {
                    System.out.printf("Place %d has Valentine's day.\n", index);
                }
            }

            input = scanner.nextLine();
        }

        System.out.printf("Cupid's last position was %d.\n", index);

        boolean successful = true;
        int failedPlacesCount = 0;
        for (int house : neighborhood) {
            if (house != 0) {
                failedPlacesCount++;
                successful = false;
            }
        }

        if (successful) {
            System.out.println("Mission was successful.");
        } else {
            System.out.printf("Cupid has failed %d places.\n", failedPlacesCount);
        }

    }
}