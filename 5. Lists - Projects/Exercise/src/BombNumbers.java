import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = new ArrayList<>(Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList()));
        int bombNumber = scanner.nextInt();
        int power = scanner.nextInt();

        while (numbers.contains(bombNumber)) {
            int index = numbers.indexOf(bombNumber);

            int end = Math.max(0, index - power);
            int start = Math.min(numbers.size(), index + power);

            for (int i = start; i >= end; i--) {
                numbers.remove(i);
            }
        }

        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }

        System.out.println(sum);
    }
}