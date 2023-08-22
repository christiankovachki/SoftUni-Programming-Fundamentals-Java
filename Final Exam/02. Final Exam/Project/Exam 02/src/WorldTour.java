import java.util.Scanner;

public class WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String stops = scanner.nextLine();
        StringBuilder stringBuilder = new StringBuilder(stops);

        String input = scanner.nextLine();
        while (!input.equals("Travel")) {
            String[] commands = input.split(":");
            
            if (commands[0].equals("Add Stop")) {
                int index = Integer.parseInt(commands[1]);
                String str = commands[2];
                if (index >= 0 && index < stringBuilder.length()) {
                    stringBuilder.insert(index, str);
                }
                System.out.println(stringBuilder);
            } else if (commands[0].equals("Remove Stop")) {
                int startIndex = Integer.parseInt(commands[1]);
                int endIndex = Integer.parseInt(commands[2]);
                if (startIndex >= 0 && startIndex < stringBuilder.length() && endIndex >= 0 && endIndex < stringBuilder.length()); {
                    stringBuilder.delete(startIndex, endIndex + 1);
                }
                System.out.println(stringBuilder);
            } else if (commands[0].equals("Switch")) {
                String oldString = commands[1];
                String newString = commands[2];

                stringBuilder = new StringBuilder(stringBuilder.toString().replace(oldString, newString));
                System.out.println(stringBuilder);
            }

            input = scanner.nextLine();
        }

        System.out.printf("Ready for world tour! Planned stops: %s\n", stringBuilder);
    }
}