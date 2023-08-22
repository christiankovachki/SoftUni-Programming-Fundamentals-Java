import java.util.Scanner;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeSet<String> vipGuests = new TreeSet<>();
        TreeSet<String> regularGuests = new TreeSet<>();

        String partyInput = scanner.nextLine();
        while (!partyInput.equals("PARTY")) {
            if (partyInput.length() == 8) {
                if (Character.isDigit(partyInput.charAt(0))) {
                    vipGuests.add(partyInput);
                } else {
                    regularGuests.add(partyInput);
                }
            }

            partyInput = scanner.nextLine();
        }

        String endInput = scanner.nextLine();
        while (!endInput.equals("END")) {
            if (vipGuests.contains(endInput)) {
                vipGuests.remove(endInput);
            } else if (regularGuests.contains(endInput)) {
                regularGuests.remove(endInput);
            }

            endInput = scanner.nextLine();
        }

        int missingGuest = vipGuests.size() + regularGuests.size();
        System.out.println(missingGuest);
        for (String guest : vipGuests) {
            System.out.println(guest);
        }
        for (String guest : regularGuests) {
            System.out.println(guest);
        }

    }
}