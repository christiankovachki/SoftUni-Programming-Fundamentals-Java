import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Pattern pattern = Pattern.compile("@(#+)[A-Z]([A-Za-z\\d]){4,}[A-Z]@(#+)");
        for (int i = 0; i < n; i++) {
            String barcodes = scanner.nextLine();
            Matcher matcher = pattern.matcher(barcodes);

            if (matcher.find()) {
                String[] productGroup = barcodes.split("[^\\d]");
                if (productGroup.length == 0) {
                    System.out.print("Product group: 00\n");
                } else {
                    StringBuilder sb = new StringBuilder();
                    for (String product : productGroup) {
                        if (!Objects.equals(product, "")) {
                            sb.append(product);
                        }
                    }

                    System.out.printf("Product group: %s\n", sb);
                }
            } else {
                System.out.println("Invalid barcode");
            }
        }
    }
}