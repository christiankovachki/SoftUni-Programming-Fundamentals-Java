import java.util.Scanner;
public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int ordersCount = Integer.parseInt(scanner.nextLine());

        float total = 0;

        for (int i = 1; i <= ordersCount; i++) {
            float pricePerCapsule = Float.parseFloat(scanner.nextLine());
            int days = Integer.parseInt(scanner.nextLine());
            int capsulesCount = Integer.parseInt(scanner.nextLine());

            float orderPrice = ((days * capsulesCount) * pricePerCapsule);
            total += orderPrice;

            System.out.printf("The price for the coffee is: $%.2f\n", orderPrice);
        }

        System.out.printf("Total: $%.2f", total);
    }
}