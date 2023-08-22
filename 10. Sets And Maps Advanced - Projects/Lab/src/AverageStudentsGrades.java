import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, ArrayList<Double>> studentsRecord = new TreeMap<>();

        int numberOfStudents = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfStudents; i++) {
            String nameOfStudent = scanner.next();
            double grade = Double.parseDouble(scanner.nextLine());

            if (studentsRecord.containsKey(nameOfStudent)) {
                studentsRecord.get(nameOfStudent).add(grade);
            } else {
                studentsRecord.put(nameOfStudent, new ArrayList<>());
                studentsRecord.get(nameOfStudent).add(grade);
            }
        }

        for (Map.Entry<String, ArrayList<Double>> student : studentsRecord.entrySet()) {
            System.out.printf("%s -> ", student.getKey());
            double total = 0;
            for (int i = 0; i < student.getValue().size(); i++) {
                total += student.getValue().get(i);
                System.out.printf("%.2f ", student.getValue().get(i));
            }

            System.out.printf("(avg: %.2f)", total / student.getValue().size());
            System.out.println();
        }

    }
}