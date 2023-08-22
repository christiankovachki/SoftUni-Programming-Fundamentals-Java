import java.util.Scanner;
public class WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int waterTankCapacity = 255;

        for (int i = 0; i < n; i++) {
            int litersOfWater = Integer.parseInt(scanner.nextLine());

            if (waterTankCapacity >= litersOfWater) {
                waterTankCapacity -= litersOfWater;
            } else {
                System.out.println("Insufficient capacity!");
            }
        }

        System.out.printf("%d", 255 - waterTankCapacity);
    }
}