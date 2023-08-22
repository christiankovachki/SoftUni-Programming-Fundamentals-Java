import java.util.Arrays;
import java.util.Scanner;
public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        String command = scanner.nextLine();
        while (!command.equals("end")) {
            if (command.contains("swap")) {
                String[] swapCommand = command.split(" ");
                int firstIndex = Integer.parseInt(swapCommand[1]);
                int secondIndex = Integer.parseInt(swapCommand[2]);

                int tempIndex = 0;
                for (int i = 0; i < numbers.length; i++) {
                    if (firstIndex == i) {
                        tempIndex = numbers[i];
                        numbers[i] = numbers[secondIndex];
                        numbers[secondIndex] = tempIndex;
                        break;
                    }
                }
            } else if (command.contains("multiply")) {
                String[] swapCommand = command.split(" ");
                int firstIndex = Integer.parseInt(swapCommand[1]);
                int secondIndex = Integer.parseInt(swapCommand[2]);

                int firstNumber = 0;
                int secondNumber = 0;
                for (int i = 0; i < numbers.length; i++) {
                    if (firstIndex == i) {
                        firstNumber = numbers[i];
                    } else if (secondIndex == i) {
                        secondNumber = numbers[i];
                    }
                }
                int result = firstNumber * secondNumber;
                numbers[firstIndex] = result;
            } else if (command.contains("decrease")) {
                for (int i = 0; i < numbers.length; i++) {
                    numbers[i] = numbers[i] - 1;
                }
            }

            command = scanner.nextLine();
        }

        for (int i = 0; i < numbers.length - 1; i++) {
            System.out.printf("%d, ", numbers[i]);
        }
        System.out.printf("%d\n", numbers[numbers.length - 1]);
    }
}