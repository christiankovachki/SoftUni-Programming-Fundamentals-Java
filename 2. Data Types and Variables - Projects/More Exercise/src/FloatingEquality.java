import java.util.Scanner;
public class FloatingEquality {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double numberA = Double.parseDouble(scanner.nextLine());
        double numberB = Double.parseDouble(scanner.nextLine());

        if ((numberA > numberB - 0.000001) && (numberA < numberB + 0.000001)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}