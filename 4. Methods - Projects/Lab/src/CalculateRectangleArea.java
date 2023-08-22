import java.util.Scanner;
public class CalculateRectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(calculatingAreaOfRect(scanner.nextInt(), scanner.nextInt()));
    }

    public static int calculatingAreaOfRect (int width, int length) {

        return width * length;
    }
}