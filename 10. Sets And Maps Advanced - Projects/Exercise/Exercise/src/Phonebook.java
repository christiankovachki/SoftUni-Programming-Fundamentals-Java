import java.util.Scanner;
import java.util.TreeMap;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, String> phonebook = new TreeMap<>();

        String input = scanner.nextLine();
        while (!input.equals("search")) {
            String[] contact = input.split("-");
            String contactName = contact[0];
            String contactPhone = contact[1];

            if (phonebook.containsKey(contactName)) {
                phonebook.put(contactName, contactPhone);
            } else {
                phonebook.put(contactName, contactPhone);
            }

            input = scanner.nextLine();
        }

        String contactName = scanner.nextLine();
        while (!contactName.equals("stop")) {
            if (!phonebook.containsKey(contactName)) {
                System.out.printf("Contact %s does not exist.\n", contactName);
            } else {
                System.out.printf("%s -> %s\n", contactName, phonebook.get(contactName));
            }

            contactName = scanner.nextLine();
        }

    }
}