import java.util.*;

public class Students {
    static class Student {
        String firstName;
        String lastName;
        double grade;

        Student(String firstName, String lastName, double grade) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.grade = grade;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getFirstName() {
            return this.firstName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getLastName() {
            return this.lastName;
        }

        public void setGrade(double grade) {
            this.grade = grade;
        }

        public double getGrade() {
            return this.grade;
        }

        @Override
        public String toString() {
            return String.format("%s %s: %.2f", getFirstName(), getLastName(), getGrade());
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Student> students = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String firstName = scanner.next();
            String lastName = scanner.next();
            double grade = Double.parseDouble(scanner.next());

            Student student = new Student(firstName, lastName, grade);
            students.add(student);
        }

        students.sort(Comparator.comparing(Student::getGrade));
        Collections.reverse(students);

        for (Student student : students) {
            System.out.println(student.toString());
        }

    }
}