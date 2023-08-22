import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder sb = new StringBuilder(scanner.nextLine());

        String input = scanner.nextLine();
        while (!input.equals("Done")) {
            String[] command = input.split(" ");

            if (command[0].equals("TakeOdd")) {
                StringBuilder newRawPassword = new StringBuilder();
                for (int i = 0; i < sb.length(); i++) {
                    if (i % 2 != 0) {
                        newRawPassword.append(sb.charAt(i));
                    }
                }

                sb = new StringBuilder(newRawPassword);
                System.out.println(sb);
            } else if (command[0].equals("Cut")) {
                int index = Integer.parseInt(command[1]);
                int length = Integer.parseInt(command[2]);

                sb.delete(index, index + length);
                System.out.println(sb);
            } else if (command[0].equals("Substitute")) {
                String substr = command[1];
                String replacement = command[2];

                if (sb.toString().contains(substr)) {
                    sb = new StringBuilder(sb.toString().replace(substr, replacement));
                    System.out.println(sb);
                } else {
                    System.out.println("Nothing to replace!");
                }
            }

            input = scanner.nextLine();
        }

        System.out.printf("Your password is: %s\n", sb);
    }
}