import java.util.Scanner;
public class Matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        printNxnMatrix(number);
    }

    public static void printNxnMatrix(int number) {
        for (int i = 0; i < number; i++) {
            System.out.print(number + " ");

            for (int j = 0; j < number - 1; j++) {
                System.out.print(number + " ");
            }

            System.out.println();
        }
    }

}