import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).sorted(Collections.reverseOrder()).limit(3).collect(Collectors.toList());

        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}