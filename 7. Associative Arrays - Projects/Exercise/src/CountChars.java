import java.util.*;
import java.util.stream.Collectors;

public class CountChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> input = Arrays.stream(scanner.nextLine().split("")).map(c -> c.trim()).collect(Collectors.toList());

        LinkedHashMap<String, Integer> countsOfChars = new LinkedHashMap<>();
        for (String s : input) {
            if (!s.isEmpty()) {
                if (countsOfChars.containsKey(s)) {
                    countsOfChars.put(s, countsOfChars.get(s) + 1);
                } else {
                    countsOfChars.put(s, 1);
                }
            }
        }

        for (Map.Entry<String, Integer> entry : countsOfChars.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }

    }
}