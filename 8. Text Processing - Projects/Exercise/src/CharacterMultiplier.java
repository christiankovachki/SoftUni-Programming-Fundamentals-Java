import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int result = characterMultiplier(input[0], input[1]);
        System.out.println(result);
    }

    public static int characterMultiplier(String str1, String str2) {
        int sum = 0;

        int longerStr = Math.max(str1.length(), str2.length());
        int shorterStr = Math.min(str1.length(), str2.length());
        for (int i = 0; i < shorterStr; i++) {
            char str1Char = str1.charAt(i);
            char str2Char = str2.charAt(i);

            sum += str1Char * str2Char;
        }

        if (longerStr != shorterStr) {
            for (int i = shorterStr; i < longerStr; i++) {
                if (str1.length() > str2.length()) {
                    sum += str1.charAt(i);
                } else {
                    sum += str2.charAt(i);
                }
            }
        }

        return sum;
    }
}