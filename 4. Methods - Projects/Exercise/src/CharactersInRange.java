import java.util.Scanner;
public class CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char firstChar = scanner.next().charAt(0);
        char secondChar = scanner.next().charAt(0);

        getCharsInRange(firstChar, secondChar);
    }

    public static void getCharsInRange(char firstChar, char secondChar) {
        int start = Math.min(firstChar, secondChar);
        int finish = Math.max(firstChar, secondChar);

        for (int i = start + 1; i < finish; i++) {
            char character = (char) Integer.parseInt(String.valueOf(i));
            System.out.print(character + " ");
        }
    }

}