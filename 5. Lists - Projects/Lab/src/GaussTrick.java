import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GaussTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = new ArrayList<>(Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList()));

        int end = numbers.size() / 2;
        for (int i = 0; i < end; i++) {
            sumNumbers(numbers, i);
        }

        for (int number : numbers) {
            System.out.print(number + " ");
        }

        System.out.println();
    }

    public static void sumNumbers(List<Integer> numbers, int index) {
        int firstNumber = numbers.get(index);
        int secondNumber = numbers.get(numbers.size() - 1);
        int sum = firstNumber + secondNumber;

        numbers.add(index, sum);
        numbers.remove(index + 1);
        numbers.remove(numbers.size() - 1);
    }
}