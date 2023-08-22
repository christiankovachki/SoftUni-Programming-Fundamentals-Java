import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EnterNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> validNumbers = new ArrayList<>(10);

        while (validNumbers.size() < 10) {
            try {
                int number = Integer.parseInt(scanner.nextLine());
                if (number > 1 && number < 100) {
                    validNumbers.add(String.valueOf(number));
                } else {
                    System.out.printf("Your number is not in range %d - 100!\n", validNumbers.size() + 1);
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Invalid Number!");
            }
        }

        System.out.println(String.join(", ", validNumbers));

    }
}