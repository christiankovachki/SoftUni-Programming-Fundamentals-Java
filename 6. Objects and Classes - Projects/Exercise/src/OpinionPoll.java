import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class OpinionPoll {
    static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getAge() {
            return this.age;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String name = scanner.next();
            int age = Integer.parseInt(scanner.next());

            Person person = new Person(name, age);
            people.add(person);
        }

        for (Person person : people) {
            if (person.getAge() > 30) {
                System.out.printf("%s - %d\n", person.getName(), person.getAge());
            }
        }

    }
}