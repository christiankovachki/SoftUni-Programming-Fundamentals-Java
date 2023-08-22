import java.util.Scanner;
public class IntegerOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        int divide = 0;
        int multiply = 0;

        for (int i = 1; i <= 4; i++) {
            int number = Integer.parseInt(scanner.nextLine());

            if (i <= 2) {
                sum += number;
            } else if (i == 3) {
                divide = sum / number;
            } else {
                multiply = divide * number;
            }
        }

        System.out.println(multiply);
//        int first = Integer.parseInt(scanner.nextLine());
//        int second = Integer.parseInt(scanner.nextLine());
//        int third = Integer.parseInt(scanner.nextLine());
//        int fourth = Integer.parseInt(scanner.nextLine());
//
//        int sum = first + second;
//        int divide = sum / third;
//        int multiply = divide * fourth;
//
//        System.out.println(multiply);
    }
}