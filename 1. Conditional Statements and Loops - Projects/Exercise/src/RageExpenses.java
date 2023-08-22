import java.util.Scanner;
public class RageExpenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lostGamesCount = Integer.parseInt(scanner.nextLine());
        float headsetPrice = Float.parseFloat(scanner.nextLine());
        float mousePrice = Float.parseFloat(scanner.nextLine());
        float keyboardPrice = Float.parseFloat(scanner.nextLine());
        float displayPrice = Float.parseFloat(scanner.nextLine());

        int headsetTrashingCount = 0;
        int mouseTrashingCount = 0;
        int keyboardTrashingCount = 0;
        int displayTrashingCount = 0;

        for (int i = 1; i <= lostGamesCount; i++) {

            if (i % 2 == 0) {
                headsetTrashingCount++;
            }

            if (i % 3 == 0) {
                mouseTrashingCount++;
            }

            if (i % 2 == 0 && i % 3 == 0) {
                keyboardTrashingCount++;
                if (keyboardTrashingCount % 2 == 0) {
                    displayTrashingCount++;
                }
            }
        }

        float total = headsetTrashingCount * headsetPrice + mouseTrashingCount * mousePrice + keyboardTrashingCount * keyboardPrice + displayTrashingCount * displayPrice;
        System.out.printf("Rage expenses: %.2f lv.", total);
    }
}