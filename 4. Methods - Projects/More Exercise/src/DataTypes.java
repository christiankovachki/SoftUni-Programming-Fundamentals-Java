import java.util.Scanner;
public class DataTypes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        switch (input) {
            case "int":
                getInputDataType(Integer.parseInt(scanner.nextLine()));
                break;
            case "real":
                getInputDataType(Double.parseDouble(scanner.nextLine()));
                break;
            case "string":
                getInputDataType(scanner.nextLine());
                break;
        }
    }

    public static void getInputDataType(int number) {
        System.out.println(number * 2);
    }

    public static void getInputDataType(double number) {
        double result = number * 1.5;
        System.out.printf("%.2f\n", result);
    }

    public static void getInputDataType(String str) {
        System.out.println("$" + str + "$");
    }
}