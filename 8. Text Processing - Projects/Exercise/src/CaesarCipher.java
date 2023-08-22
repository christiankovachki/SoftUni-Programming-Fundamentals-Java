import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        StringBuilder sb = new StringBuilder(input.length());
        for (int i = 0; i < input.length(); i++) {
            int symbolDecValue = input.charAt(i) + 3;
            char symbol = (char) symbolDecValue;
            sb.append(symbol);
        }

        System.out.println(sb.toString());
    }
}