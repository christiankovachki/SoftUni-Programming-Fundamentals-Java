import java.util.Scanner;
public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        StringBuilder sb = new StringBuilder();

        for (int i = input.length() - 1; i >= 0; i--) {
            char letter = input.charAt(i);

            sb.append(letter);
        }

        System.out.println(sb.toString());
    }
}