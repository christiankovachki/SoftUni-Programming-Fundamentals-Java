import java.util.Scanner;
public class RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        repeatingString(scanner.nextLine(), scanner.nextInt());
    }

    public static String repeatingString(String input, int repeatCount) {
        for (int i = 0; i < repeatCount; i++) {
            System.out.printf("%s", input);
        }

        return input;
    }

}