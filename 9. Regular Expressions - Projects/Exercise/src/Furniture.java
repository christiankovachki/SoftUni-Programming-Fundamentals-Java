import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern pattern = Pattern.compile(">>(?<name>\\w+)<<(?<price>\\d+[.]?\\d+)!(?<quantity>\\d+)");

        List<String> boughtFurniture = new ArrayList<>();
        double totalMoney = 0.0;

        String input = scanner.nextLine();
        while (!input.equals("Purchase")) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String furniture = matcher.group("name");
                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantity"));

                boughtFurniture.add(furniture);
                totalMoney += price * quantity;
            }

            input = scanner.nextLine();
        }

        System.out.println("Bought furniture:");
        for (String furniture : boughtFurniture) {
            System.out.println(furniture);
        }
        System.out.printf("Total money spend: %.2f\n", totalMoney);
    }
}