import java.util.*;
import java.util.stream.Collectors;

public class AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> numbersAsString = new ArrayList<>(Arrays.stream(scanner.nextLine().split("\\|"))
                .collect(Collectors.toList()));

        Collections.reverse(numbersAsString);

        String output = numbersAsString.toString().replaceAll("[\\]\\[,]", "").trim();
        System.out.println(output.replaceAll("\\s+", " "));
    }
}