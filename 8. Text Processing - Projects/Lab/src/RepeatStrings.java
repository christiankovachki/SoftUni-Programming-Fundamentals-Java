import java.util.Scanner;

public class RepeatStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length; i++) {
            int length = input[i].length();
            for (int j = 0; j < length; j++) {
                sb.append(input[i]);
            }
        }

        System.out.println(sb.toString());
    }
}