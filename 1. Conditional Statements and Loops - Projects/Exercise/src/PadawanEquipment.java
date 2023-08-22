import java.util.Scanner;
public class PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        float amountOfMoney = Float.parseFloat(scanner.nextLine());
        int studentsCount = Integer.parseInt(scanner.nextLine());
        float singleSaberPrice = Float.parseFloat(scanner.nextLine());
        float singleRobePrice = Float.parseFloat(scanner.nextLine());
        float singleBeltPrice = Float.parseFloat(scanner.nextLine());


        int freeBelts = studentsCount / 6;
        int lightSabersCeil = (int) Math.ceil(studentsCount * 1.10);

        float neededMoney = singleSaberPrice * lightSabersCeil + singleRobePrice * studentsCount + singleBeltPrice * (studentsCount - freeBelts);

        if (amountOfMoney >= neededMoney) {
            System.out.printf("The money is enough - it would cost %.2flv.\n", neededMoney);
        } else {
            System.out.printf("George Lucas will need %.2flv more.\n", neededMoney - amountOfMoney);
        }
    }
}