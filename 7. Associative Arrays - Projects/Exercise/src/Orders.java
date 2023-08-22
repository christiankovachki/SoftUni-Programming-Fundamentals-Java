import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, ArrayList<Double>> products = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("buy")) {
            String[] productsInfo = input.split(" ");
            String name = productsInfo[0];
            double price = Double.parseDouble(productsInfo[1]);
            double quantity = Integer.parseInt(productsInfo[2]);

            if (products.containsKey(name)) {
                double currentQuantity = products.get(name).get(1);
                products.get(name).set(1, currentQuantity + quantity);
                double currentPrice = products.get(name).get(0);
                if (price != currentPrice) {
                    products.get(name).set(0, price);
                }
            } else {
                ArrayList<Double> priceAndQuantity = new ArrayList<>();
                priceAndQuantity.add(price);
                priceAndQuantity.add(quantity);
                products.put(name, priceAndQuantity);
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, ArrayList<Double>> entry : products.entrySet()) {
            double price = entry.getValue().get(0);
            double quantity = entry.getValue().get(1);

            double totalPrice = price * quantity;
            System.out.printf("%s -> %.2f\n", entry.getKey(), totalPrice);
        }

    }
}