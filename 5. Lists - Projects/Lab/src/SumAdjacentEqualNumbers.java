import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SumAdjacentEqualNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       List<Double> numbers = new ArrayList<>(Arrays.stream(scanner.nextLine().split(" ")).map(Double::parseDouble).collect(Collectors.toList()));

       int index = 0;
       while (index < numbers.size() - 1) {
           double firstNumber = numbers.get(index);
           double secondNumber = numbers.get(index + 1);

           if (firstNumber == secondNumber) {
                double sum = firstNumber + secondNumber;

                numbers.set(index, sum);
                numbers.remove(index + 1);
                index = 0;
           } else {
               index++;
           }
       }

        printOutput(numbers);
    }

    public static void printOutput(List<Double> numbers) {
        String output = "";
        for (double number : numbers) {
            output += new DecimalFormat("0.#").format(number) + " ";
        }

        System.out.println(output);
    }
}