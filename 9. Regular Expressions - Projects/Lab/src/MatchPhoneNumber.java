import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchPhoneNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String phoneNumbers = scanner.nextLine();

        Pattern pattern = Pattern.compile("\\+359([- ])2\\1\\d{3}\\1\\d{4}");
        Matcher matcher = pattern.matcher(phoneNumbers);

        List<String> validPhones = new ArrayList<>();
        while (matcher.find()) {
            validPhones.add(matcher.group());
        }

        System.out.print(String.join(", ", validPhones));
        System.out.println();
    }
}