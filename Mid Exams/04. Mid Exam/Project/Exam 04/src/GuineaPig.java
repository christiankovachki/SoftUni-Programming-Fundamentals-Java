import java.util.Scanner;
public class GuineaPig {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        float quantityOfFood = Float.parseFloat(scanner.nextLine()) * 1000; // in Kilos (* 1000 for grams) per 30 days
        float quantityOfHay  = Float.parseFloat(scanner.nextLine()) * 1000; // in Kilos (* 1000 for grams) per 30 days
        float quantityOfCover = Float.parseFloat(scanner.nextLine()) * 1000; // in Kilos (* 1000 for grams) per 30 days
        float guineaWeight = Float.parseFloat(scanner.nextLine()) * 1000; // in Kilos (* 1000 for grams) per 30 days

        boolean isEnough = true;

        for (int day = 1; day <= 30; day++) {
            quantityOfFood -= 300;

            if (day % 2 == 0) {
                quantityOfHay -= quantityOfFood * 0.05;
            }

            if (day % 3 == 0) {
                quantityOfCover -= guineaWeight / 3;
            }

            if (quantityOfFood <= 0 || quantityOfHay <= 0 || quantityOfCover <= 0) {
                isEnough = false;
                break;
            }
        }

        if (isEnough) {
            float excessFood = quantityOfFood / 1000;
            float excessHay = quantityOfHay / 1000;
            float excessCover = quantityOfCover / 1000;
            System.out.printf("Everything is fine! Puppy is happy! Food: %.2f, Hay: %.2f, Cover: %.2f.\n", excessFood, excessHay, excessCover);
        } else {
            System.out.println("Merry must go to the pet store!");
        }
    }
}