import java.util.Scanner;
public class GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String type = scanner.nextLine();

        switch (type) {
            case "int":
                System.out.println(getMax(scanner.nextInt(), scanner.nextInt()));
                break;
            case "char":
                System.out.println(getMax(scanner.next().charAt(0), scanner.next().charAt(0)));
                break;
            case "string":
                System.out.println(getMax(scanner.nextLine(), scanner.nextLine()));
                break;
        }

    }

    public static int getMax(int firstValue, int secondValue) {
        if (firstValue > secondValue) {
            return firstValue;
        }

        return secondValue;
    }

    public static char getMax(char firstChar, char secondChar) {
        if (firstChar > secondChar) {
            return firstChar;
        }

        return secondChar;
    }

    public static String getMax(String firstStr, String secondStr) {
        if (firstStr.compareTo(secondStr) >= 0) {
            return firstStr;
        }

        return secondStr;
    }
}