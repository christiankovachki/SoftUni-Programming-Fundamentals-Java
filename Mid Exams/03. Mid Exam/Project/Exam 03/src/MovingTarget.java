import java.util.*;
import java.util.stream.Collectors;

public class MovingTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> sequenceOfTargets = new ArrayList<>(Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList()));

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] arr = input.split(" ");
            String command = arr[0];
            int index = Integer.parseInt(arr[1]);

            if (command.equals("Shoot")) {
                int power = Integer.parseInt(arr[2]);
                shoot(sequenceOfTargets, index, power);
            } else if (command.equals("Add")) {
                int value = Integer.parseInt(arr[2]);
                add(sequenceOfTargets, index, value);
            } else if (command.equals("Strike")) {
                int radius = Integer.parseInt(arr[2]);
                strike(sequenceOfTargets, index, radius);
            }

            input = scanner.nextLine();
        }

        System.out.println(sequenceOfTargets.stream().map(String::valueOf).collect(Collectors.joining("|")));

    }

    static void strike(List<Integer> sequenceOfTargets, int index, int radius) {
        if (index - radius >= 0 && index + radius < sequenceOfTargets.size() - 1) {
            int start = index + radius;
            int end = index - radius;
            for (int i = start; i >= end; i--) {
                sequenceOfTargets.remove(i);
            }
        } else {
            System.out.println("Strike missed!");
        }
    }

    static void add(List<Integer> sequenceOfTargets, int index, int value) {
        if (index < 0 || index >= sequenceOfTargets.size()) {
            System.out.println("Invalid placement!");
        } else {
            sequenceOfTargets.set(index, value);
        }

    }

    static void shoot(List<Integer> sequenceOfTargets, int index, int power) {
        if (index >= 0 && index < sequenceOfTargets.size()) {
            int target = sequenceOfTargets.get(index);

            target -= power;
            sequenceOfTargets.set(index, target);
            if (target <= 0) {
                sequenceOfTargets.remove(index);
            }
        }
    }
}