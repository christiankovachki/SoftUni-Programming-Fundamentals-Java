import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = new ArrayList<>(Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList()));

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] str = input.split(" ");
            String command = str[0];

            int number = 0;
            int index = 0;
            switch (command){
                case "Add":
                    number = Integer.parseInt(str[1]);
                    numbers.add(number);
                    break;
                case "Remove":
                    number = Integer.parseInt(str[1]);
                    numbers.remove(Integer.valueOf(number));
                    break;
                case "RemoveAt":
                    index = Integer.parseInt(str[1]);
                    numbers.remove(index);
                    break;
                case "Insert":
                    number = Integer.parseInt(str[1]);
                    index = Integer.parseInt(str[2]);
                    numbers.add(index, number);
                    break;
            }

            input = scanner.nextLine();
        }

        for (int number : numbers) {
            System.out.print(number + " ");
        }

    }
}