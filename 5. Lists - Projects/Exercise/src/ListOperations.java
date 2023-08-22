import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = new ArrayList<>(Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList()));

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] str = input.split(" ");
            String command = str[0];

            switch (command) {
                case "Add":
                    int addNumber = Integer.parseInt(str[1]);
                    numbers.add(addNumber);
                    break;
                case "Insert":
                    int insertNumber = Integer.parseInt(str[1]);
                    int insertAtIndex = Integer.parseInt(str[2]);
                    boolean checkInsert = checkIndex(numbers, insertAtIndex);
                    if (checkInsert) {
                        numbers.add(insertAtIndex, insertNumber);
                    }
                    break;
                case "Remove":
                    int removeAtIndex = Integer.parseInt(str[1]);
                    boolean checkRemove = checkIndex(numbers, removeAtIndex);
                    if (checkRemove) {
                        numbers.remove(removeAtIndex);
                    }
                    break;
                case "Shift":
                    if (str[1].equals("left")) {
                        int count = Integer.parseInt(str[2]);
                        shiftingLeft(numbers, count);
                    } else if (str[1].equals("right")) {
                        int count = Integer.parseInt(str[2]);
                        shiftingRight(numbers, count);
                    }
                    break;
            }

            input = scanner.nextLine();
        }

        for (int number : numbers) {
            System.out.print(number + " ");
        }

        System.out.println();
    }

    private static void shiftingRight(List<Integer> numbers, int count) {
        for (int i = 0; i < count; i++) {
            int number = numbers.get(numbers.size() - 1);
            numbers.remove(numbers.size() - 1);
            numbers.add(0, number);
        }
    }

    public static void shiftingLeft(List<Integer> numbers, int count) {
        for (int i = 0; i < count; i++) {
            int number = numbers.get(0);
            int lastIndex = numbers.size() - 1;
            numbers.remove(0);
            numbers.add(lastIndex, number);
        }
    }

    public static boolean checkIndex(List<Integer> numbers, int index) {
        if (numbers.size() <= index || index < 0) {
            System.out.println("Invalid index");
        } else {
            return true;
        }

        return false;
    }
}