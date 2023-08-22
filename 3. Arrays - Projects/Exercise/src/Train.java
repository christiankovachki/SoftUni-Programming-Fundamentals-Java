import java.util.Scanner;
public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int wagonCount = Integer.parseInt(scanner.nextLine());

        int[] people = new int[wagonCount];
        int sum = 0;
        for (int i = 0; i < wagonCount; i++) {
            people[i] = Integer.parseInt(scanner.nextLine());
            sum += people[i];
            System.out.printf("%d ", people[i]);
        }

        System.out.println();
        System.out.println(sum);
    }
}