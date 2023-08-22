import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile("(=|\\/)[A-Z]([a-zA-Z]{2,})+\\1");
        Matcher matcher = pattern.matcher(input);

        ArrayList<String> destinations = new ArrayList<>();
        while (matcher.find()) {
            destinations.add(matcher.group());
        }

        int travelPoints = 0;
        for (int i = 0; i < destinations.size(); i++) {
            String destination = destinations.get(i);
            destination = destination.substring(1, destination.length() - 1);
            destinations.set(i, destination);
            travelPoints += destination.length();
        }

        System.out.print("Destinations: ");
        System.out.print(String.join(", ", destinations));
        System.out.println();
        System.out.printf("Travel Points: %d\n", travelPoints);
    }
}