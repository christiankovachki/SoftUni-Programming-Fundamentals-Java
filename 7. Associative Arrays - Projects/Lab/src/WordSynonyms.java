import java.util.*;

public class WordSynonyms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, ArrayList<String>> synonymsOfWords = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String word = scanner.nextLine();
            String synonym = scanner.nextLine();

            synonymsOfWords.putIfAbsent(word, new ArrayList<>());
            synonymsOfWords.get(word).add(synonym);
        }

        for (Map.Entry<String, ArrayList<String>> entry : synonymsOfWords.entrySet()) {
            System.out.printf("%s - ", entry.getKey());
            System.out.print(String.join(", ", entry.getValue()));
            System.out.println();
        }

    }
}