import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        ArrayList<String> mirrorWords = new ArrayList<>();

        Pattern pattern = Pattern.compile("([@#])(?<wordOne>[a-zA-Z]{3,})\\1\\1(?<wordTwo>[a-zA-Z]{3,})\\1");
        Matcher matcher = pattern.matcher(text);
        int wordPairsCounter = 0;
        while (matcher.find()) {
            wordPairsCounter++;
            String firstWord = matcher.group("wordOne");
            String secondWord = matcher.group("wordTwo");

            StringBuilder sb = new StringBuilder(secondWord);
            String reversedWord = String.valueOf(sb.reverse());
            if (firstWord.equals(reversedWord)) {
                mirrorWords.add(firstWord + " <=> " + secondWord);
            }
        }

        if (wordPairsCounter != 0) {
            System.out.printf("%d word pairs found!\n", wordPairsCounter);
        } else {
            System.out.println("No word pairs found!");
        }

        if (mirrorWords.isEmpty()) {
            System.out.println("No mirror words!");
        } else {
            System.out.println("The mirror words are:");
            System.out.print(String.join(", ", mirrorWords));
        }
    }
}