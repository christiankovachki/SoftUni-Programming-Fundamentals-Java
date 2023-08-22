import java.util.Scanner;
public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int groupCount = Integer.parseInt(scanner.nextLine());
        String groupType = scanner.nextLine();
        String dayOfWeek = scanner.nextLine();

        double pricePerPerson = 0;

        switch (dayOfWeek) {
            case "Friday":
                if (groupType.equals("Students")) {
                    pricePerPerson = 8.45;
                } else if (groupType.equals("Business")) {
                    pricePerPerson = 10.90;
                } else if (groupType.equals("Regular")) {
                    pricePerPerson = 15;
                }
                break;
            case "Saturday":
                if (groupType.equals("Students")) {
                    pricePerPerson = 9.80;
                } else if (groupType.equals("Business")) {
                    pricePerPerson = 15.60;
                } else if (groupType.equals("Regular")) {
                    pricePerPerson = 20;
                }
                break;
            case "Sunday":
                if (groupType.equals("Students")) {
                    pricePerPerson = 10.46;
                } else if (groupType.equals("Business")) {
                    pricePerPerson = 16;
                } else if (groupType.equals("Regular")) {
                    pricePerPerson = 22.50;
                }
                break;
        }

        double totalPrice = groupCount * pricePerPerson;

        if (groupType.equals("Students") && groupCount >= 30) {
            totalPrice = totalPrice - (totalPrice * 0.15);
        } else if (groupType.equals("Business") && groupCount >= 100) {
            totalPrice = (groupCount - 10) * pricePerPerson;
        } else if (groupType.equals("Regular") && groupCount >= 10 && groupCount <= 20) {
            totalPrice = totalPrice - (totalPrice * 0.05);
        }

        System.out.printf("Total price: %.2f\n", totalPrice);

    }
}