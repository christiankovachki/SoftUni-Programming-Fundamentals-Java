import java.util.LinkedHashSet;
import java.util.Scanner;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.next());
        int m = Integer.parseInt(scanner.next());

        LinkedHashSet<Integer> setN = new LinkedHashSet<>();
        LinkedHashSet<Integer> setM = new LinkedHashSet<>();
        LinkedHashSet<Integer> setRepeatingElement = new LinkedHashSet<>();

        for (int i = 0; i < n + m; i++) {
            int integer = scanner.nextInt();

            if (i < n) {
                setN.add(integer);
            } else {
                setM.add(integer);
            }
        }

        setRepeatingElement.addAll(setN);
        setRepeatingElement.addAll(setM);

        setRepeatingElement.removeIf(el -> !setN.contains(el) || !setM.contains(el));
        for (Integer el : setRepeatingElement) {
            System.out.print(el + " ");
        }

        System.out.println();
    }
}