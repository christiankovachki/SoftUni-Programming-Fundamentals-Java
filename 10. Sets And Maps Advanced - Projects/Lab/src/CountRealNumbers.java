import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<Double, Integer> realNumbersCount = new LinkedHashMap<>();
        double[] inputNumbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(n -> Double.parseDouble(n)).toArray();
        for (int i = 0; i < inputNumbers.length; i++) {

            if (realNumbersCount.containsKey(inputNumbers[i])) {
                int currentCount = realNumbersCount.get(inputNumbers[i]);
                realNumbersCount.put(inputNumbers[i], currentCount + 1);
            } else {
                realNumbersCount.put(inputNumbers[i], 1);
            }
        }

        for (Map.Entry<Double, Integer> entry : realNumbersCount.entrySet()) {
            System.out.printf("%.1f -> %d\n", entry.getKey(), entry.getValue());
        }

    }
}