import java.util.Scanner;
public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        calculatingOrderTotalPrice(scanner.nextLine(), scanner.nextInt());
    }

    public static void calculatingOrderTotalPrice (String product, int quantity) {
        double priceOfProduct = 0;
        switch (product) {
            case "coffee":
                priceOfProduct = 1.5;
                break;
            case "water":
                priceOfProduct = 1;
                break;
            case "coke":
                priceOfProduct = 1.4;
                break;
            case "snacks":
                priceOfProduct = 2;
                break;
        }

        System.out.printf("%.2f", priceOfProduct * quantity);
    }
}