import java.util.*;
import java.util.stream.Collectors;

public class RandomizeWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> words = new ArrayList<>(Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList()));
        Random rnd = new Random();

        for (int i = 0; i < words.size(); i++) {
            int index = rnd.nextInt(words.size());
            String word = words.get(index);
            words.remove(index);
            words.add(word);
        }

        for (String word : words) {
            System.out.printf("%s\n", word);
        }

    }
}