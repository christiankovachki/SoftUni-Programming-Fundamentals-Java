import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class HeroesOfCodeAndLogicVII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, ArrayList<Integer>> heroes = new LinkedHashMap<>();

        addingHeroes(scanner, heroes);

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] command = input.split(" - ");

            if (command[0].equals("CastSpell")) {
                castingSpell(heroes, command);
            } else if (command[0].equals("TakeDamage")) {
                takingDamage(heroes, command);
            } else if (command[0].equals("Recharge")) {
                recharging(heroes, command);
            } else if (command[0].equals("Heal")) {
                healing(heroes, command);
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, ArrayList<Integer>> entry : heroes.entrySet()) {
            System.out.println(entry.getKey());
            System.out.printf(" HP: %d\n", entry.getValue().get(0));
            System.out.printf(" MP: %d\n", entry.getValue().get(1));
        }

    }

    public static void healing(LinkedHashMap<String, ArrayList<Integer>> heroes, String[] command) {
        String heroName = command[1];
        int amount = Integer.parseInt(command[2]);

        int currentHP = heroes.get(heroName).get(0);
        int hpAfterHeal = currentHP + amount;

        if (hpAfterHeal > 100) {
            heroes.get(heroName).set(0, 100);
            System.out.printf("%s healed for %d HP!\n", heroName, 100 - currentHP);
        } else {
            heroes.get(heroName).set(0, hpAfterHeal);
            System.out.printf("%s healed for %d HP!\n", heroName, amount);
        }
    }

    public static void recharging(LinkedHashMap<String, ArrayList<Integer>> heroes, String[] command) {
        String heroName = command[1];
        int amount = Integer.parseInt(command[2]);

        int currentMP = heroes.get(heroName).get(1);
        int mpAfterRecharge = currentMP + amount;

        if (mpAfterRecharge > 200) {
            heroes.get(heroName).set(1, 200);
            System.out.printf("%s recharged for %d MP!\n", heroName, 200 - currentMP);
        } else {
            heroes.get(heroName).set(1, mpAfterRecharge);
            System.out.printf("%s recharged for %d MP!\n", heroName, amount);
        }
    }

    public static void takingDamage(LinkedHashMap<String, ArrayList<Integer>> heroes, String[] command) {
        String heroName = command[1];
        int damage = Integer.parseInt(command[2]);
        String attacker = command[3];

        int currentHP = heroes.get(heroName).get(0);
        int hpAfterDamage = currentHP - damage;
        if (hpAfterDamage > 0) {
            heroes.get(heroName).set(0, hpAfterDamage);
            System.out.printf("%s was hit for %d HP by %s and now has %d HP left!\n",
                    heroName, damage, attacker, hpAfterDamage);
        } else {
            heroes.remove(heroName);
            System.out.printf("%s has been killed by %s!\n", heroName, attacker);
        }
    }

    public static void castingSpell(LinkedHashMap<String, ArrayList<Integer>> heroes, String[] command) {
        String heroName = command[1];
        int neededMP = Integer.parseInt(command[2]);
        String spellName = command[3];

        int currentMP = heroes.get(heroName).get(1);
        if (currentMP >= neededMP) {
            int reducedMP = currentMP - neededMP;
            heroes.get(heroName).set(1, reducedMP);
            System.out.printf("%s has successfully cast %s and now has %d MP!\n",
                    heroName, spellName, reducedMP);
        } else {
            System.out.printf("%s does not have enough MP to cast %s!\n",
                    heroName, spellName);
        }
    }

    public static void addingHeroes(Scanner scanner, LinkedHashMap<String, ArrayList<Integer>> heroes) {
        int numberOfHeroes = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfHeroes; i++) {
            //{hero name} {HP} {MP}
            String[] input = scanner.nextLine().split(" ");
            String heroName = input[0];
            int hp = Integer.parseInt(input[1]);
            int mp = Integer.parseInt(input[2]);

            heroes.put(heroName, new ArrayList<>());
            heroes.get(heroName).add(hp);
            heroes.get(heroName).add(mp);
        }
    }
}