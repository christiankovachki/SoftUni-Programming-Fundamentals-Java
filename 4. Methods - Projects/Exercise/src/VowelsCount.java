import java.util.Scanner;
public class VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(getVowelsCount(scanner.nextLine()));
    }

    public static int getVowelsCount(String input) {
        int counter = 0;

        for (int i = 0; i < input.length(); i++) {
            char letter = Character.toLowerCase(input.charAt(i));

            switch (letter) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                case 'y':
                    counter++;
                    break;
            }
        }

        return counter;
    }
}