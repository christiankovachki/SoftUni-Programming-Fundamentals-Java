import java.util.Scanner;
public class RefactorSpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= number; i++) {
            int currentNumber = i;

            int sum = 0;
            while (currentNumber > 0) {
                sum += currentNumber % 10;
                currentNumber = currentNumber / 10;
            }

            boolean isSpecial = (sum == 5) || (sum == 7) || (sum == 11);
            System.out.printf("%d -> %b\n", i, isSpecial);

// ТОВА Е РЕШЕНИЕТО ЗА JUDGE, ТЪЙ КАТО С КОДА ОТГОРЕ ДАВА 0т.
//            boolean isSpecial = (sum == 5) || (sum == 7) || (sum == 11);
//            if (isSpecial) {
//                System.out.printf("%d -> True\n", i);
//            } else {
//                System.out.printf("%d -> False\n", i);
//            }
        }
    }
}