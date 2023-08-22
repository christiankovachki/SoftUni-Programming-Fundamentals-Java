import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = new ArrayList<>(Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList()));

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] str = input.split(" ");
            String command = str[0];

            if (command.equals("Delete")) {
                int deleteElement = Integer.parseInt(str[1]);
                numbers.remove(Integer.valueOf(deleteElement));
            } else if (command.equals("Insert")) {
                int insertElement = Integer.parseInt(str[1]);
                int position = Integer.parseInt(str[2]);
                numbers.add(position, insertElement);
            }

            input = scanner.nextLine();
        }

        for (int number : numbers) {
            System.out.print(number + " ");
        }

    }
}