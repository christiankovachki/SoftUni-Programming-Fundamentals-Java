import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, ArrayList<String>> foodShops = new TreeMap<>();

        String input = scanner.nextLine();
        while (!input.equals("Revision")) {
            String[] info = input.split(", ");
            String shop = info[0];
            String product = info[1];
            double price = Double.parseDouble(info[2]);

            if (foodShops.containsKey(shop)) {
                foodShops.get(shop).add(product);
                foodShops.get(shop).add(String.valueOf(String.format("%.1f", price)));
            } else {
                foodShops.put(shop, new ArrayList<>());
                foodShops.get(shop).add(product);
                foodShops.get(shop).add(String.valueOf(String.format("%.1f", price)));
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, ArrayList<String>> shop : foodShops.entrySet()) {
            System.out.printf("%s->\n", shop.getKey());
            for (int i = 0; i < shop.getValue().size(); i += 2) {
                System.out.printf("Product: %s, ", shop.getValue().get(i));
                System.out.printf("Price: %s\n", shop.getValue().get(i + 1));
            }
        }

    }
}