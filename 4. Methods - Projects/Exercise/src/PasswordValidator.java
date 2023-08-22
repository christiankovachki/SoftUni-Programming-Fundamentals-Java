import java.util.Scanner;
public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String passwordInput = scanner.nextLine();

        boolean firstCondition = getPresenceOfLettersAndDigits(passwordInput);
        boolean secondCondition = getPasswordLength(passwordInput);
        boolean thirdCondition = getDigitPresence(passwordInput);

        if (firstCondition && secondCondition && thirdCondition) {
            System.out.println("Password is valid");
        }
    }

    public static boolean getPresenceOfLettersAndDigits(String input) {
        for (int i = 0; i < input.length(); i++) {
            char character = input.charAt(i);

            if (!Character.isLetterOrDigit(character)) {
                System.out.println("Password must consist only of letters and digits");
                return false;
            }
        }

        return true;
    }

    public static boolean getPasswordLength(String input) {
        if (input.length() >= 6 && input.length() <= 10) {
            return true;
        }

        System.out.println("Password must be between 6 and 10 characters");
        return false;
    }

    public static boolean getDigitPresence(String input) {
        int counter = 0;

        for (int i = 0; i < input.length(); i++) {
            char character = input.charAt(i);

            if (character >= 48 && character <= 57) {
                counter++;
                if (counter == 2) {
                    return true;
                }
            }
        }

        System.out.println("Password must have at least 2 digits");
        return false;
    }

}