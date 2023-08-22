import java.util.Scanner;
public class GamingStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        float currentBalance = Float.parseFloat(scanner.nextLine());

        float totalSpent = 0f;

        String input = scanner.nextLine();
        while (!input.equals("Game Time")) {
            boolean isGameValid = true;
            float gamePrice = 0f;

            switch (input) {
                case "OutFall 4":
                    gamePrice = 39.99f;
                    break;
                case "CS: OG":
                    gamePrice = 15.99f;
                    break;
                case "Zplinter Zell":
                    gamePrice = 19.99f;
                    break;
                case "Honored 2":
                    gamePrice = 59.99f;
                    break;
                case "RoverWatch":
                    gamePrice = 29.99f;
                    break;
                case "RoverWatch Origins Edition":
                    gamePrice = 39.99f;
                    break;
                default:
                    System.out.println("Not Found");
                    isGameValid = false;
                    break;
            }
            
            if (gamePrice <= currentBalance && isGameValid) {
                System.out.printf("Bought %s\n", input);
                totalSpent += gamePrice;
                currentBalance -= gamePrice;
            } else if (gamePrice > currentBalance && isGameValid) {
                System.out.println("Too Expensive");
            }

            if (currentBalance == 0) {
                System.out.println("Out of mo-ney!");
                break;
            }

            input = scanner.nextLine();
        }

        if (input.equals("Game Time")) {
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f\n", totalSpent, currentBalance);
        }
    }
}