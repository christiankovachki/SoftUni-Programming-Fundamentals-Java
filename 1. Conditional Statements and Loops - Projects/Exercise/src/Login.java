import java.util.Scanner;
public class Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();

        StringBuilder sb = new StringBuilder();

        for (int i = username.length() - 1; i >= 0; i--) {
            char letter = username.charAt(i);

            sb.append(letter);
        }

        String password = sb.toString();

        int failedAttempts = 0;

        String input = scanner.nextLine();
        while (!input.equals(password)) {
            failedAttempts++;

            if (failedAttempts == 4) {
                System.out.printf("User %s blocked!", username);
                break;
            }

            System.out.println("Incorrect password. Try again.");

            input = scanner.nextLine();
        }

        if (input.equals(password)) {
            System.out.printf("User %s logged in.", username);
        }

    }
}