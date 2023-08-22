import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile("\\d");
        Matcher matcher = pattern.matcher(input);

        BigInteger coolThreshold = new BigInteger("1");
        while (matcher.find()) {
            int digit = Integer.parseInt(matcher.group());
            coolThreshold = coolThreshold.multiply(BigInteger.valueOf(digit));
        }

        Pattern emojiPattern = Pattern.compile("(::|\\*\\*)([A-Z])([a-z]{2,})\\1");
        Matcher emojiMatcher = emojiPattern.matcher(input);

        ArrayList<String> coolEmojis =  new ArrayList<>();
        int emojiCounter = 0;
        while (emojiMatcher.find()) {
            emojiCounter++;

            String emoji = emojiMatcher.group();
            String trimmedEmoji = emoji.substring(2, emoji.length() - 2);
            int emojiCoolness = 0;
            for (int i = 0; i < trimmedEmoji.length(); i++) {
                emojiCoolness += trimmedEmoji.charAt(i);
            }

            if (emojiCoolness > coolThreshold.longValue()) {
                coolEmojis.add(emoji);
            }
        }

        System.out.print("Cool threshold: " + coolThreshold);
        System.out.println();
        System.out.printf("%d emojis found in the text. The cool ones are:\n", emojiCounter);
        for (String emoji : coolEmojis) {
            System.out.println(emoji);
        }
    }
}