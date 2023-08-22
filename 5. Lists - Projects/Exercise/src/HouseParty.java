import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guestList = new ArrayList<>();
        int commandsCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < commandsCount; i++) {
            String[] guestInfo = scanner.nextLine().split(" ");

            String guestName = guestInfo[0];
            if (guestInfo.length == 3) {
                addingGuest(guestName, guestList);
            } else if (guestInfo.length == 4) {
                removingGuest(guestName, guestList);
            }
        }

        for (String guest : guestList) {
            System.out.print(guest + " \n");
        }

        System.out.println();
    }

    public static void addingGuest(String guestName, List<String> guestList) {

        boolean isAlready = false;
        for (String guest : guestList) {
            if (guest.equals(guestName)) {
                System.out.printf("%s is already in the list!\n", guestName);
                isAlready = true;
                break;
            }
        }

        if (!isAlready) {
            guestList.add(guestName);
        }
    }

    public static void removingGuest(String guestName, List<String> guestList) {
        for (String guest : guestList) {
            if (guest.equals(guestName)) {
                guestList.remove(guest);
                return;
            }
        }

        System.out.printf("%s is not in the list!\n", guestName);
    }
}