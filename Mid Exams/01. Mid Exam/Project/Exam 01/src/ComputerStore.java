import java.util.Scanner;
public class ComputerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double totalPriceWithoutTax = 0;
        double totalTaxes = 0;

        String input = scanner.nextLine();
        while (!input.equals("regular") && !input.equals("special")) {
            double partPriceWithoutTax = Double.parseDouble(input);

            if (partPriceWithoutTax < 0) {
                System.out.println("Invalid price!");
            } else {
                totalPriceWithoutTax += partPriceWithoutTax;

                double tax = partPriceWithoutTax * 0.2;
                totalTaxes += tax;
            }

            input = scanner.nextLine();
        }

        if (totalPriceWithoutTax == 0) {
            System.out.println("Invalid order!");
        } else {
            double totalPrice = getTotalPrice(totalPriceWithoutTax, totalTaxes, input);
            printReceipt(totalPriceWithoutTax, totalTaxes,totalPrice);
        }
    }

    public static double getTotalPrice(double totalPriceWithoutTax, double totalTaxes, String input) {
        double totalPrice = totalPriceWithoutTax + totalTaxes;
        if (input.equals("special")) {
            totalPrice = totalPrice - (totalPrice * 0.1);
        }
        return totalPrice;
    }

    public static void printReceipt(double totalPriceWithoutTax, double totalTaxes, double totalPrice) {
        System.out.println("Congratulations you've just bought a new computer!");
        System.out.printf("Price without taxes: %.2f$\n", totalPriceWithoutTax);
        System.out.printf("Taxes: %.2f$\n", totalTaxes);
        System.out.println("-----------");
        System.out.printf("Total price: %.2f$\n", totalPrice);
    }
}