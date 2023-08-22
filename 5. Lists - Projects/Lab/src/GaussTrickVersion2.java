import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
public class GaussTrickVersion2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = new ArrayList<>(Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList()));

        List<Integer> numbersAfterSum = new ArrayList<>(numbers.size());
        for (int i = 0; i < numbers.size() / 2; i++) {
            int firstNumber = numbers.get(i);
            int secondNumber = numbers.get(numbers.size() - 1 - i);
            int sum = firstNumber + secondNumber;

            numbersAfterSum.add(i, sum);
        }

        if (numbers.size() % 2 != 0) {
            numbersAfterSum.add(numbers.get(numbers.size() / 2));
        }

        for (int number : numbersAfterSum) {
            System.out.print(number + " ");
        }

    }
}