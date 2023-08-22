import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, String> emailsCollection = new LinkedHashMap<>();
        Pattern pattern = Pattern.compile("\\.(us|uk|com)");

        String input = scanner.nextLine();
        while (!input.equals("stop")) {
            String name = input;
            String email = scanner.nextLine();

            Matcher matcher = pattern.matcher(email);
            if (!matcher.find()) {
                emailsCollection.put(name, email);
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, String> entry : emailsCollection.entrySet()) {
            System.out.printf("%s -> %s\n", entry.getKey(), entry.getValue());
        }

    }
}