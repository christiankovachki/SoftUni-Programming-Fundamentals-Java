import java.util.Scanner;
public class VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double totalCoins = 0;

        String input = scanner.nextLine();
        while (!input.equals("Start")) {
            double coins = Double.parseDouble(input);

            if (coins == 0.1 || coins == 0.2 || coins == 0.5 || coins == 1 || coins == 2) {
                totalCoins += coins;
            } else {
                System.out.printf("Cannot accept %.2f\n", coins);
            }

            input = scanner.nextLine();
        }

        double productPrice = 0;

        String productInput = scanner.nextLine();
        while (!productInput.equals("End")) {
            boolean isProductValid = true;

            switch (productInput) {
                case "Nuts":
                    productPrice = 2;
                    break;
                case "Water":
                    productPrice = 0.7;
                    break;
                case "Crisps":
                    productPrice = 1.5;
                    break;
                case "Soda":
                    productPrice = 0.8;
                    break;
                case "Coke":
                    productPrice = 1;
                    break;
                default:
                    System.out.println("Invalid product");
                    isProductValid = false;
                    break;
            }

            if (productPrice <= totalCoins && isProductValid) {
                System.out.printf("Purchased %s\n", productInput);
                totalCoins -= productPrice;
            } else if (productPrice > totalCoins && isProductValid){
                System.out.println("Sorry, not enough money");
            }

            productInput = scanner.nextLine();
        }

        System.out.printf("Change: %.2f\n", totalCoins);
    }
}