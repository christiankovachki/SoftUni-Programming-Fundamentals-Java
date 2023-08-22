import java.util.Scanner;
public class DayOfWeek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] daysOfTheWeek = {
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday",
                "Sunday",
        };

        int dayNumber = Integer.parseInt(scanner.nextLine());

        if (dayNumber < 1 || dayNumber > 7) {
            System.out.println("Invalid day!");
        } else {
            System.out.println(daysOfTheWeek[dayNumber - 1]);
        }

    }
}