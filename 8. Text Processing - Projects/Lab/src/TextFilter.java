import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] bannedWord = scanner.nextLine().split(", ");
        String text = scanner.nextLine();

        for (int i = 0; i < bannedWord.length; i++) {
            if (text.contains(bannedWord[i])) {
                String replacement = "";
                for (int j = 0; j < bannedWord[i].length(); j++) {
                    replacement = replacement.concat("*");
                }

                text = text.replace(bannedWord[i], replacement);            }
        }

        System.out.println(text);
    }
}