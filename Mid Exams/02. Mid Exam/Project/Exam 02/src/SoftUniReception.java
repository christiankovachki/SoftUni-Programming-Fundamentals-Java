import java.util.Scanner;
public class SoftUniReception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstEmployeeEfficiency = Integer.parseInt(scanner.nextLine());
        int secondEmployeeEfficiency = Integer.parseInt(scanner.nextLine());
        int thirdEmployeeEfficiency = Integer.parseInt(scanner.nextLine());
        int studentsCount = Integer.parseInt(scanner.nextLine());

        int totalEfficiencyPerHour = firstEmployeeEfficiency + secondEmployeeEfficiency + thirdEmployeeEfficiency;
        int neededHours = 0;
        while (studentsCount > 0) {
            neededHours++;
            if (neededHours % 4 == 0) {
                continue;
            }

            studentsCount -= totalEfficiencyPerHour;
        }

        System.out.printf("Time needed: %dh.\n", neededHours);
    }
}