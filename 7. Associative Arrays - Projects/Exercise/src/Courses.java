import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, List<String>> courses = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] information = input.split(" : ");
            String courseName = information[0];
            String studentName = information[1];

            if (courses.containsKey(courseName)) {
                courses.get(courseName).add(studentName);
            } else {
                courses.put(courseName, new ArrayList<>());
                courses.get(courseName).add(studentName);
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : courses.entrySet()) {
            System.out.printf("%s: %d\n", entry.getKey(), entry.getValue().size());
            for (int i = 0; i < entry.getValue().size(); i++) {
                System.out.printf("-- %s\n", entry.getValue().get(i));
            }
        }

    }
}