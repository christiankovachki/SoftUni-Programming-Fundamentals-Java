import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, LinkedHashMap<String, Integer>> collection = new TreeMap<>();

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] token = input.split(" ");
            String ip = token[0].substring(3);
            String username = token[2].substring(5);

            if (collection.containsKey(username)) {
                if (collection.get(username).containsKey(ip)) {
                    int currentCount = collection.get(username).get(ip);
                    collection.get(username).put(ip, currentCount + 1);
                } else {
                    collection.get(username).put(ip, 1);
                }
            } else {
                collection.put(username, new LinkedHashMap<>());
                collection.get(username).put(ip, 1);
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, LinkedHashMap<String, Integer>> username : collection.entrySet()) {
            System.out.printf("%s:\n", username.getKey());
        }

    }
}