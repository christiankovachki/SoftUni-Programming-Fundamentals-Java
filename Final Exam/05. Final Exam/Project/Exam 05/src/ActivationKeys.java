import java.util.Scanner;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder activationKey = new StringBuilder(scanner.nextLine());

        String input = scanner.nextLine();
        while (!input.equals("Generate")) {
            String[] operation = input.split(">>>");

            if (operation[0].equals("Contains")) {
                String substr = operation[1];
                if (activationKey.toString().contains(substr)) {
                    System.out.printf("%s contains %s\n", activationKey, substr);
                } else {
                    System.out.println("Substring not found!");
                }
            } else if (operation[0].equals("Flip")) {
                int startIndex = Integer.parseInt(operation[2]);
                int endIndex = Integer.parseInt(operation[3]);

                String substr = activationKey.substring(startIndex, endIndex);

                switch (operation[1]) {
                    case "Upper":
                        activationKey = new StringBuilder(activationKey.toString().replace(substr, substr.toUpperCase()));
                        break;
                    case "Lower":
                        activationKey = new StringBuilder(activationKey.toString().replace(substr, substr.toLowerCase()));
                        break;
                }

                System.out.println(activationKey);
            } else if (operation[0].equals("Slice")) {
                int startIndex = Integer.parseInt(operation[1]);
                int endIndex = Integer.parseInt(operation[2]);

                activationKey.delete(startIndex, endIndex);
                System.out.println(activationKey);
            }

            input = scanner.nextLine();
        }

        System.out.printf("Your activation key is: %s\n", activationKey);
    }
}