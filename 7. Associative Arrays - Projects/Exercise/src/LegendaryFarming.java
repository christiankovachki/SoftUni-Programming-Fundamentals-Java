import java.util.*;
import java.util.stream.Collectors;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, Integer> keyMaterials = new HashMap<>();
        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);

        LinkedHashMap<String, Integer> junk = new LinkedHashMap<>();

        int numberOfShards = 0;
        int numberOfFragments = 0;
        int numberOfMotes = 0;

        while (numberOfShards < 250 || numberOfFragments < 250 || numberOfMotes < 250) {
            List<String> input = Arrays.stream(scanner.nextLine().split("\\s+")).map(String::toLowerCase).collect(Collectors.toList());

            for (int i = 0; i < input.size(); i += 2) {
                String material = input.get(i + 1);
                int quantity = Integer.parseInt(input.get(i));
            }
        }
    }
}