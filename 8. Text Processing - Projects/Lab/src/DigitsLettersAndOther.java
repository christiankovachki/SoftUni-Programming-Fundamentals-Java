import java.util.Scanner;

public class DigitsLettersAndOther {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder sbOfDigits = new StringBuilder();
        StringBuilder sbOfLetters = new StringBuilder();
        StringBuilder sbOfOther = new StringBuilder();

        StringBuilder sb = new StringBuilder(scanner.nextLine());
        for (int i = 0; i < sb.length(); i++) {
            if (Character.isDigit(sb.charAt(i))) {
                sbOfDigits.append(sb.charAt(i));
            } else if (Character.isLetter(sb.charAt(i))) {
                sbOfLetters.append(sb.charAt(i));
            } else {
                sbOfOther.append(sb.charAt(i));
            }
        }

        System.out.println(sbOfDigits);
        System.out.println(sbOfLetters);
        System.out.println(sbOfOther);
    }
}