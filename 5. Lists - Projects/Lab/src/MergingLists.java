import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstListOfNumbers = new ArrayList<>(Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList()));
        List<Integer> secondListOfNumbers = new ArrayList<>(Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList()));

        List<Integer> resultList = new ArrayList<>(firstListOfNumbers.size() + secondListOfNumbers.size());
        int index = 0;
        for (int i = 0; i < Math.min(firstListOfNumbers.size(), secondListOfNumbers.size()); i++) {
            resultList.add(firstListOfNumbers.get(i));
            resultList.add(secondListOfNumbers.get(i));
            index = i;
        }

        if (firstListOfNumbers.size() != secondListOfNumbers.size()) {
            for (int i = index + 1; i < Math.max(firstListOfNumbers.size(), secondListOfNumbers.size()); i++) {
                if (firstListOfNumbers.size() > secondListOfNumbers.size()) {
                    resultList.add(firstListOfNumbers.get(i));
                } else {
                    resultList.add(secondListOfNumbers.get(i));
                }
            }
        }

        for (int number : resultList) {
            System.out.print(number + " ");
        }

    }
}