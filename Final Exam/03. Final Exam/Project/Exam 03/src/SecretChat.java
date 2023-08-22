import java.util.Scanner;

public class SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String concealedMessage = scanner.nextLine();

        StringBuilder sb = new StringBuilder(concealedMessage);
        String input = scanner.nextLine();
        while (!input.equals("Reveal")) {
            String[] instruction = input.split(":\\|:");
            
            if (instruction[0].equals("InsertSpace")) {
                int index = Integer.parseInt(instruction[1]);
                sb.insert(index, " ");
                System.out.println(sb);
            } else if (instruction[0].equals("Reverse")) {
                String substr = instruction[1];
                if (sb.toString().contains(substr)) {
                    StringBuilder reverseSubstr = new StringBuilder(substr);
                    reverseSubstr.reverse();

                    int start = sb.indexOf(substr);
                    int end = start + substr.length();
                    sb.delete(start, end);
                    sb.append(reverseSubstr);
                    System.out.println(sb);
                } else {
                    System.out.println("error");
                }
            } else if (instruction[0].equals("ChangeAll")) {
                String substr = instruction[1];
                String replacement = instruction[2];

                sb = new StringBuilder(sb.toString().replace(substr, replacement));

                System.out.println(sb);
            }

            input = scanner.nextLine();
        }

        System.out.printf("You have a new text message: %s\n", sb);
    }
}