import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern keyPattern = Pattern.compile("[SsTtAaRr]");
        Pattern pattern = Pattern.compile("@(?<planet>[A-Z][a-z]+)[^@:!\\->]*:(?<population>\\d+)[^@:!\\->]*!(?<type>[A|D])![^@:!\\->]*->(?<soldiers>\\d+)");

        List<String> attackedPlanets = new ArrayList<>();
        List<String> destroyedPlanets = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String encryptedMessage = scanner.nextLine();
            Matcher keyMatcher = keyPattern.matcher(encryptedMessage);
            int lettersCount =  getLettersCount(encryptedMessage, keyMatcher);

            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < encryptedMessage.length(); j++) {
                char c = (char) (encryptedMessage.charAt(j) - lettersCount);
                stringBuilder.append(c);
            }

            Matcher matcher = pattern.matcher(stringBuilder);
            if (matcher.find()) {
                String planetName = matcher.group("planet");
                String type = matcher.group("type");

                if (type.equals("A")) {
                    attackedPlanets.add(planetName);
                } else if (type.equals("D")){
                    destroyedPlanets.add(planetName);
                }
            }
        }

        System.out.printf("Attacked planets: %d\n", attackedPlanets.size());
        attackedPlanets.stream().sorted().forEach(e -> System.out.printf("-> %s\n", e));
        System.out.printf("Destroyed planets: %d\n", destroyedPlanets.size());
        destroyedPlanets.stream().sorted().forEach(e -> System.out.printf("-> %s\n", e));
    }

    public static int getLettersCount(String encryptedMessage, Matcher matcher) {
        int lettersCount = 0;
        for (int j = 0; j < encryptedMessage.length(); j++) {
            if (matcher.find()) {
                lettersCount++;
            }
        }
        return lettersCount;
    }
}