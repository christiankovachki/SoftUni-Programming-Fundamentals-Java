import java.util.*;
import java.util.stream.Collectors;

public class RemoveNegativesAndReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = new ArrayList<>(Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList()));;

        Collections.reverse(removeNegativeNumbers(numbers));

        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }

    public static List<Integer> removeNegativeNumbers(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) < 0) {
                numbers.remove(i);
                i--;
            }
        }

        if (numbers.isEmpty()) {
            System.out.println("empty");
        }

        return numbers;
    }
}