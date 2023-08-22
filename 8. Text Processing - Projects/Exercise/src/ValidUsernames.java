import java.util.Scanner;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        for (int i = 0; i < input.length; i++) {
            String username = input[i];

            boolean isValid = isUsernameValid(username);
            if (isValid) {
                System.out.println(username);
            }
        }
    }

    private static boolean isUsernameValid(String username) {
        if (username.length() < 3 || username.length() > 16) {
            return false;
        }

        for (int i = 0; i < username.length(); i++) {
            char character = username.charAt(i);

            if (!Character.isLetterOrDigit(character) && character != '-' && character != '_') {
                return false;
            }
        }

        return true;
    }
}