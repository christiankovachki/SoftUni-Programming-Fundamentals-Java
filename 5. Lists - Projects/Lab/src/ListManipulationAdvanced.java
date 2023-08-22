import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = new ArrayList<>(Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList()));

        String input = scanner.nextLine();
        while (!input.equals("end")) {
         String[] command = input.split(" ");

         int number = 0;
         String condition = "";
         switch (command[0]) {
             case "Contains":
                 number = Integer.parseInt(command[1]);
                 System.out.println(checkNumberInList(numbers, number));
                 break;
             case "Print":
                 if (command[1].equals("even")) {
                    printEvenNumbers(numbers);
                 } else if (command[1].equals("odd")) {
                     printOddNumbers(numbers);
                 }
                 break;
             case "Get":
                 if (command[1].equals("sum")) {
                     System.out.println(getSumOfNumbers(numbers));
                 }
                 break;
             case "Filter":
                 condition = command[1];
                 number = Integer.parseInt(command[2]);
                 filterByCondition(numbers, condition, number);
                 break;
         }

         input = scanner.nextLine();
        }
    }

    public static String checkNumberInList(List<Integer> numbers, int number) {
        String output = "";

        for (int integer : numbers) {
            if (integer == number) {
                output = "Yes";
                return output;
            }
        }

        output = "No such number";
        return output;
    }

    public static void printEvenNumbers(List<Integer> numbers) {
        for (int number : numbers) {
            if (number % 2 == 0) {
                System.out.print(number + " ");
            }
        }

        System.out.println();
    }

    public static void printOddNumbers(List<Integer> numbers) {
        for (int number : numbers) {
            if (number % 2 != 0) {
                System.out.print(number + " ");
            }
        }

        System.out.println();
    }

    public static int getSumOfNumbers(List<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }

        return sum;
    }

    public static void filterByCondition(List<Integer> numbers, String condition, int number) {
        for (int integer : numbers) {
            switch (condition) {
                case ">=":
                    if (integer >= number) {
                        System.out.print(integer + " ");
                    }
                    break;
                case "<=":
                    if (integer <= number) {
                        System.out.print(integer + " ");
                    }
                    break;
                case ">":
                    if (integer > number) {
                        System.out.print(integer + " ");
                    }
                    break;
                case "<":
                    if (integer < number) {
                        System.out.print(integer + " ");
                    }
                    break;
            }
        }

        System.out.println();
    }
}