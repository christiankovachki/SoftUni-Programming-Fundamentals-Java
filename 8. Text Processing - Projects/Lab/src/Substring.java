import java.util.Scanner;

public class Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String key = scanner.nextLine();
        String input = scanner.nextLine();

        int startIndex = input.indexOf(key);
        for (int i = startIndex; i < input.length(); i++) {
            input = input.replace(key, "");
        }

        System.out.println(input);
    }
}