import java.util.*;
import java.util.stream.Collectors;

public class Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = new ArrayList<>(Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList()));

        double sum = 0;
        for (int number : numbers) {
            sum += number;
        }

        double avgNumber = sum / numbers.size();
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) <= avgNumber) {
                numbers.remove(i);
                i--;
            }
        }

        if (numbers.isEmpty()) {
            System.out.println("No");
        } else {
            List<Integer> topFive = new ArrayList<>(5);
            int size = numbers.size();
            for (int i = 0; i < size; i++) {
                topFive.add(Collections.max(numbers));
                numbers.remove(Collections.max(numbers));
                if (topFive.size() == 5) {
                    break;
                }
            }

            for (int integer : topFive) {
                System.out.print(integer + " ");
            }
        }
    }
}