import java.util.Scanner;

public class TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String encryptedMessage = scanner.nextLine();

        StringBuilder stringBuilder = new StringBuilder(encryptedMessage);
        String input = scanner.nextLine();
        while (!input.equals("Decode")) {
            String[] instruction = input.split("\\|");

            if (instruction[0].equals("Move")) {
                int numberOfLetters = Integer.parseInt(instruction[1]);
                for (int i = 0; i < numberOfLetters; i++) {
                    stringBuilder.append(stringBuilder.charAt(i));
                }

                stringBuilder.delete(0, numberOfLetters);
            } else if (instruction[0].equals("Insert")) {
                int index = Integer.parseInt(instruction[1]);
                String character = instruction[2];
                stringBuilder.insert(index, character);
            } else if (instruction[0].equals("ChangeAll")) {
                String sub = instruction[1];
                String replacement = instruction[2];
                for (int i = 0; i < stringBuilder.length(); i++) {
                    String character = String.valueOf(stringBuilder.charAt(i));
                    if (character.equals(sub)) {
                        stringBuilder.insert(i, replacement);
                        stringBuilder.deleteCharAt(i + 1);
                    }
                }
            }

            input = scanner.nextLine();
        }

        System.out.printf("The decrypted message is: %s\n", stringBuilder.toString());
    }
}