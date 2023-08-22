import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Students {
    public static class Student {
        String firstName;
        String lastName;
        int age;
        String hometown;

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

            Student student = new Student();
            student.setFirstName(inputAsArr[0]);
            student.setLastName(inputAsArr[1]);
            student.setAge(Integer.parseInt(inputAsArr[2]));
            student.setHometown(inputAsArr[3]);

            students.add(student);
            input = scanner.nextLine();
        }

        String city = scanner.nextLine();
        for (Student student : students) {
            if (city.equals(student.getHometown())) {
                System.out.printf("%s %s is %d years old\n", student.getFirstName(), student.getLastName(), student.getAge());
            }
        }
    }
}