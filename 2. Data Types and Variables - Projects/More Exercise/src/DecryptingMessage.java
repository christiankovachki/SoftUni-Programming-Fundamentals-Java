import java.util.Scanner;
public class DecryptingMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int key = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char letters = scanner.next().charAt(0);

            int ascii = (int) letters + key;
            char newLetter = (char) ascii;

            stringBuilder.append(newLetter);
        }

        System.out.println(stringBuilder);
    }
}