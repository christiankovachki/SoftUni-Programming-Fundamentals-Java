import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Students2 {

    public static class Student {
        String firstName;
        String lastName;
        int age;
        String hometown;

        Student(String firstName, String lastName, int age, String hometown) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.hometown = hometown;
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

        public void setAge(int age) {
            this.age = age;
        }

        public int getAge() {
            return this.age;
        }

        public void setHometown(String hometown) {
            this.hometown = hometown;
        }

        public String getHometown() {
            return hometown;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Student> students = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] inputAsArr = input.split(" ");
            String firstName = inputAsArr[0];
            String lastName = inputAsArr[1];
            int age = Integer.parseInt(inputAsArr[2]);
            String hometown = inputAsArr[3];

            if (isStudentExisting(firstName, lastName, students)) {
                Student student = overwriteStudent(firstName, lastName, students);

                student.setFirstName(firstName);
                student.setLastName(lastName);
                student.setAge(age);
                student.setHometown(hometown);
            } else {
                Student student = new Student(firstName, lastName, age, hometown);
                students.add(student);
            }

            input = scanner.nextLine();
        }

        String city = scanner.nextLine();
        for (Student student : students) {
            if (city.equals(student.getHometown())) {
                System.out.printf("%s %s is %d years old\n", student.getFirstName(), student.getLastName(), student.getAge());
            }
        }
    }

    public static Student overwriteStudent(String firstName, String lastName, List<Student> students) {
        Student existingStudent = null;
        for (Student student : students) {
            if (firstName.equals(student.getFirstName()) && lastName.equals(student.getLastName())) {
                existingStudent = student;
            }
        }

        return existingStudent;
    }

    public static boolean isStudentExisting(String firstName, String lastName, List<Student> students) {
        for (Student student : students) {
            if (firstName.equals(student.getFirstName()) && lastName.equals(student.getLastName())) {
                return true;
            }
        }

        return false;
    }

}