import java.math.BigDecimal;
import java.util.Scanner;
public class PokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pokePower = Integer.parseInt(scanner.nextLine()); // N
        int distance = Integer.parseInt(scanner.nextLine()); // M, distance between the poke targets
        int exhaustionFactor = Integer.parseInt(scanner.nextLine()); // Y

        double calcPercentage = pokePower * 0.5;
        int pokedTargets = 0;

        while (pokePower >= distance) {
            pokePower -= distance;
            pokedTargets++;

            if (pokePower == calcPercentage) {
                if (exhaustionFactor != 0) {
                    pokePower = pokePower / exhaustionFactor;
                }
            }
        }

        System.out.println(pokePower);
        System.out.println(pokedTargets);
    }
}