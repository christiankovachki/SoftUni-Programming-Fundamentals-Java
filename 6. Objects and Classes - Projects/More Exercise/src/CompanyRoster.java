import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
public class CompanyRoster {

    static class Employee {
        private String name;
        private double salary;
        private String position;
        private String department;
        private String emailAddress;
        private int age;

        public Employee(String name, double salary, String position, String department, String emailAddress, int age) {
            this.name = name;
            this.salary = salary;
            this.position = position;
            this.department = department;
            this.emailAddress = emailAddress;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public double getSalary() {
            return salary;
        }

        public String getEmailAddress() {
            return emailAddress;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return String.format("%s %.2f %s %d", getName(), getSalary(), getEmailAddress(), getAge());
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");

            String name = input[0];
            double salary = Double.parseDouble(input[1]);
            String position = input[2];
            String department = input[3];
            String emailAddress  = "n/a";
            int age = -1;

            if (input.length == 5) {
                if (input[4].contains("@")) {
                    emailAddress  = input[4];
                } else {
                    age = Integer.parseInt(input[4]);
                }
            } else if (input.length == 6) {
                emailAddress  = input[4];
                age = Integer.parseInt(input[5]);
            }

            Employee employee = new Employee(name, salary, position, department, emailAddress, age);
            employees.add(employee);
        }

        for (Employee employee : employees) {

        }

    }
}