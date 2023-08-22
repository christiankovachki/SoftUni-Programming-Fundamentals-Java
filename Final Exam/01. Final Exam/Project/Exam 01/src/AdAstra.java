import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Pattern pattern = Pattern.compile("(#|\\|)(?<food>[A-Z][a-z]+(\\s[A-Z][a-z]+)?)\\1(?<date>[0-9]{2}/[0-9]{2}/[0-9]{2})\\1(?<cals>\\d{1,5})\\1");
        Matcher matcher = pattern.matcher(text);

        ArrayList<String> info = new ArrayList<>();
        int totalCals = 0;
        while (matcher.find()) {
            String foodName = matcher.group("food");
            String expDate = matcher.group("date");
            String cals = matcher.group("cals");

            info.add("Item: " + foodName + ", Best before: " + expDate + ", Nutrition: " + cals);
            totalCals += Integer.parseInt(cals);
        }

        int days = totalCals / 2000;
        System.out.printf("You have food to last you for: %d days!\n", days);
        for (String item : info) {
            System.out.println(item);
        }
    }
}