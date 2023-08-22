import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, String> registeredCars = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String command = scanner.next();
            String username = scanner.next();

            switch (command) {
                case "register":
                    String licensePlateNumber = scanner.nextLine();

                    if (registeredCars.containsKey(username)) {
                        System.out.printf("ERROR: already registered with plate number%s\n", registeredCars.get(username));
                    } else {
                        registeredCars.put(username, licensePlateNumber);
                        System.out.printf("%s registered%s successfully\n", username, licensePlateNumber);
                    }
                    break;
                case "unregister":
                    if (!registeredCars.containsKey(username)) {
                        System.out.printf("ERROR: user %s not found\n", username);
                    } else {
                        registeredCars.remove(username);
                        System.out.printf("%s unregistered successfully\n", username);
                    }
                    break;
            }
        }

        for (Map.Entry<String, String> entry : registeredCars.entrySet()) {
            System.out.printf("%s =>%s\n", entry.getKey(), entry.getValue());
        }

    }
}