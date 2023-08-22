import java.util.Scanner;
public class DataTypeFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            if (input.equals("true") || input.equals("false")) {
                System.out.printf("%s is boolean type\n", input);
            } else if (input.contains(".")) {
                try {
                    float number = Float.parseFloat(input);
                    System.out.printf("%s is floating point type\n", input);
                } catch (Exception e) {
                    break;
                }
            } else if (input.matches("\\d+")) {
                System.out.printf("%s is integer type\n", input);
            } else if (input.matches("[A-Za-z]")) {
                System.out.printf("%s is character type\n", input);
            } else {
                System.out.printf("%s is string type\n", input);
            }

            input = scanner.nextLine();
        }
    }
}