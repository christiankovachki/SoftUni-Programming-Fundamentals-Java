import java.util.Scanner;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeSet<String> uniqueChemicals = new TreeSet<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] token = scanner.nextLine().split(" ");
            for (int j = 0; j < token.length; j++) {
                uniqueChemicals.add(token[j]);
            }
        }

        for (String chemical : uniqueChemicals) {
            System.out.printf("%s ", chemical);
        }

    }
}