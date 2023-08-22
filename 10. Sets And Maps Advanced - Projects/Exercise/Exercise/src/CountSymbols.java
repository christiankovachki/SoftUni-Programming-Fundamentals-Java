import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, Integer> occurrences = new TreeMap<>();

        String input = scanner.nextLine();
        for (int i = 0; i < input.length(); i++) {
            if (occurrences.containsKey(String.valueOf(input.charAt(i)))) {
                int current = occurrences.get(String.valueOf(input.charAt(i)));
                occurrences.put(String.valueOf(input.charAt(i)), current + 1);
            } else {
                occurrences.put(String.valueOf(input.charAt(i)), 1);
            }
        }

        for (Map.Entry<String, Integer> entry : occurrences.entrySet()) {
            System.out.printf("%s: %d time/s\n", entry.getKey(), entry.getValue());
        }

    }
}