import java.util.*;
import java.util.stream.Collectors;

public class OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> sequenceOfWords = Arrays.stream(scanner.nextLine().split(" "))
                .map(w -> w.toLowerCase())
                .collect(Collectors.toList());

        LinkedHashMap<String, Integer> totalOccurrences = new LinkedHashMap<>();
        for (String word : sequenceOfWords) {
            if (totalOccurrences.containsKey(word)) {
                totalOccurrences.put(word, totalOccurrences.get(word) + 1);
            } else {
                totalOccurrences.put(word, 1);
            }

        }

        List<String> wordWithOddOccurrences = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : totalOccurrences.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                wordWithOddOccurrences.add(entry.getKey());
            }
        }

        StringJoiner print = new StringJoiner(", ");
        wordWithOddOccurrences.forEach(i -> print.add(i.toString()));
        System.out.println(print);
    }
}