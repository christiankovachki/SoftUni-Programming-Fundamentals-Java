import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, List<String>> companyEmployees = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] token = input.split(" -> ");
            String companyName = token[0];
            String employeeId = token[1];

            if (companyEmployees.containsKey(companyName)) {
                if (!companyEmployees.get(companyName).contains(employeeId)) {
                    companyEmployees.get(companyName).add(employeeId);
                }
            } else {
                companyEmployees.put(companyName, new ArrayList<>());
                companyEmployees.get(companyName).add(employeeId);
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : companyEmployees.entrySet()) {
            System.out.println(entry.getKey());
            for (int i = 0; i < entry.getValue().size(); i++) {
                System.out.printf("-- %s\n", entry.getValue().get(i));
            }
        }

    }
}