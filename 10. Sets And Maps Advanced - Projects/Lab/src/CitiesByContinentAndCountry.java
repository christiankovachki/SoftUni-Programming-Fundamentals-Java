import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Map<String, ArrayList<String>>> map = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String continent = scanner.next();
            String country = scanner.next();
            String city = scanner.next();

            if (map.containsKey(continent)) {
                map.get(continent).putIfAbsent(country, new ArrayList<>());
                map.get(continent).get(country).add(city);
            } else {
                map.put(continent, new LinkedHashMap<>());
                map.get(continent).put(country, new ArrayList<>());
                map.get(continent).get(country).add(city);
            }
        }

        for (Map.Entry<String, Map<String, ArrayList<String>>> continent : map.entrySet()) {
            System.out.printf("%s:\n", continent.getKey());
            for (Map.Entry<String, ArrayList<String>> country : continent.getValue().entrySet()) {
                System.out.printf(" %s -> ", country.getKey());
                for (int i = 0; i < country.getValue().size(); i++) {
                    System.out.printf(country.getValue().get(i));
                    if (i != country.getValue().size() - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println();
            }
        }

    }
}