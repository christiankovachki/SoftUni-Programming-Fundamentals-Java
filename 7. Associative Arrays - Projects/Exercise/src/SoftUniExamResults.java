import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Integer> submissions = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> results = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("exam finished")) {
            String[] token = input.split("-");
            String username = token[0];
            if (!input.contains("banned")) {
                String language = token[1];
                int points = Integer.parseInt(token[2]);

                if (!results.containsKey(username)) {
                    results.put(username, points);
                } else {
                    if (results.get(username) < points) {
                        results.put(username, points);
                    }
                }

                if (submissions.containsKey(language)) {
                    submissions.put(language, submissions.get(language) + 1);
                } else {
                    submissions.put(language, 1);
                }

            } else {
                results.remove(username);
            }

            input = scanner.nextLine();
        }

        System.out.println("Results:");
        for (Map.Entry<String, Integer> entry : results.entrySet()) {
            System.out.printf("%s | %d\n", entry.getKey(), entry.getValue());
        }

        System.out.println("Submissions:");
        for (Map.Entry<String, Integer> entry : submissions.entrySet()) {
            System.out.printf("%s - %d\n", entry.getKey(), entry.getValue());
        }

    }
}