import java.util.*;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, ArrayList<Double>> studentsInfo = new TreeMap<>();

        int numberOfStundets = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfStundets; i++) {
            String studentName = scanner.nextLine();
            double[] grades = Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(g -> Double.parseDouble(g)).toArray();
            for (int j = 0; j < grades.length; j++) {
                if (studentsInfo.containsKey(studentName)) {
                    studentsInfo.get(studentName).add(grades[j]);
                } else {
                    studentsInfo.put(studentName, new ArrayList<>());
                    studentsInfo.get(studentName).add(grades[j]);
                }
            }
        }

        for (Map.Entry<String, ArrayList<Double>> student : studentsInfo.entrySet()) {
            System.out.printf("%s is graduated with ", student.getKey());

            double total = 0;
            for (int i = 0; i < student.getValue().size(); i++) {
                total += student.getValue().get(i);
            }

            System.out.print(total / student.getValue().size());
            System.out.println();
        }
    }
}