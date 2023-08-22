import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = new ArrayList<>(Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList()));

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] str = input.split(" ");
            String command = str[0];

            switch (command) {
                case "swap":
                    int temp = numbers.get(Integer.parseInt(str[1]));
                    numbers.set(Integer.parseInt(str[1]), numbers.get(Integer.parseInt(str[2])));
                    numbers.set(Integer.parseInt(str[2]), temp);
                    break;
                case "multiply":
                    int result = numbers.get(Integer.parseInt(str[1])) * numbers.get(Integer.parseInt(str[2]));
                    numbers.set(Integer.parseInt(str[1]), result);
                    break;
                case "decrease":
                    for (int i = 0; i < numbers.size(); i++) {
                        int number = numbers.get(i);
                        numbers.set(i, number - 1);
                    }
                    break;
            }

            input = scanner.nextLine();
        }

        for (int i = 0; i < numbers.size() - 1; i++) {
            System.out.print(numbers.get(i) + ", ");
        }
        System.out.print(numbers.get(numbers.size() - 1));

    }
}