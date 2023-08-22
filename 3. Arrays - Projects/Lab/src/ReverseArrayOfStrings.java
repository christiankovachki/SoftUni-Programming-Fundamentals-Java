import java.util.Scanner;
public class ReverseArrayOfStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] sequenceOfChars = scanner.nextLine().split(" ");

        for (int i = sequenceOfChars.length - 1; i >= 0; i--) {
            System.out.print(sequenceOfChars[i] + " ");
        }
    }
}