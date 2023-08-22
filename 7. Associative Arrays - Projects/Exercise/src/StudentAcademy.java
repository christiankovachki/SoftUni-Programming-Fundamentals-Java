import java.util.*;
import java.util.stream.DoubleStream;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, List<Double>> studentsGrades = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String studentName = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            if (studentsGrades.containsKey(studentName)) {
                studentsGrades.get(studentName).add(grade);
            } else {
                studentsGrades.put(studentName, new ArrayList<>());
                studentsGrades.get(studentName).add(grade);
            }
        }

        for (Map.Entry<String, List<Double>> entry : studentsGrades.entrySet()) {
            double avg = entry.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble();
            if (avg >= 4.5) {
                System.out.printf("%s -> %.2f\n", entry.getKey(), avg);
            }
        }

    }
}