import java.util.Scanner;
public class BeerKegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        double biggestKeg = -Double.MAX_VALUE;
        String modelOfBiggestKeg = "";

        for (int i = 0; i < n; i++) {
            String model = scanner.nextLine();
            double radius = Double.parseDouble(scanner.nextLine());
            int height = Integer.parseInt(scanner.nextLine());

            double volume = Math.PI * Math.pow(radius, 2) * height;

            if (volume > biggestKeg) {
                modelOfBiggestKeg = model;
                biggestKeg = volume;
            }
        }

        System.out.println(modelOfBiggestKeg);
    }
}