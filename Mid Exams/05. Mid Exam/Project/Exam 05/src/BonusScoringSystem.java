import java.util.Scanner;
public class BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int studentsCount = Integer.parseInt(scanner.nextLine());
        int lecturesCount = Integer.parseInt(scanner.nextLine());
        int additionalBonus = Integer.parseInt(scanner.nextLine());

        double currentMax = 0;
        int attendedLectures = 0;

        for (int i = 1; i <= studentsCount; i++) {
            int attendancesPerStudent = Integer.parseInt(scanner.nextLine());
            double total = attendancesPerStudent * 1.0 / lecturesCount * (5 + additionalBonus);

            if (total >= currentMax) {
                currentMax = total;
                attendedLectures = attendancesPerStudent;
            }
        }

        System.out.printf("Max Bonus: %.0f.\n", Math.ceil(currentMax));
        System.out.printf("The student has attended %d lectures.", attendedLectures);
    }
}