import java.util.*;
import java.util.stream.Collectors;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Double::parseDouble).collect(Collectors.toList());

        TreeMap<Double, Integer> numberPairs = new TreeMap<>();

        for (int i = 0; i < numbers.size(); i++) {
            double number = numbers.get(i);
            if (numberPairs.containsKey(number)) {
                numberPairs.put(number, numberPairs.get(number) + 1);
            } else {
                numberPairs.put(number, 1);
            }
        }

        for (Map.Entry<Double, Integer> entry : numberPairs.entrySet()) {
            System.out.printf("%.0f -> %d\n", entry.getKey(), entry.getValue());
        }
    }
}