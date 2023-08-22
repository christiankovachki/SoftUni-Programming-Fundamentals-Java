import java.util.*;

public class OrderByAge {
    static class Person {
        String name;
        String id;
        int age;

        Person(String name, String id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return String.format("%s with ID: %s is %d years old.", getName(), getId(), getAge());
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] token = input.split(" ");
            String name = token[0];
            String id = token[1];
            int age = Integer.parseInt(token[2]);

            Person person = new Person(name, id , age);
            people.add(person);

            input = scanner.nextLine();
        }

        people.sort(Comparator.comparing(Person::getAge));
        for (Person person : people) {
            System.out.println(person.toString());
        }
    }
}