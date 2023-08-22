import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class NeedForSpeed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, ArrayList<Integer>> carsCollection = new LinkedHashMap<>();

        int numberOfCars = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfCars; i++) {
            String[] input = scanner.nextLine().split("\\|");

            carsCollection.put(input[0], new ArrayList<>());
            carsCollection.get(input[0]).add(Integer.parseInt(input[1]));
            carsCollection.get(input[0]).add(Integer.parseInt(input[2]));
        }

        String input = scanner.nextLine();
        while (!input.equals("Stop")) {
            String[] command = input.split(" : ");
            
            if (command[0].equals("Drive")) {
                driving(carsCollection, command);
            } else if (command[0].equals("Refuel")) {
                refueling(carsCollection, command);
            } else if (command[0].equals("Revert")) {
                reverting(carsCollection, command);
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, ArrayList<Integer>> entry : carsCollection.entrySet()) {
            System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.\n",
                    entry.getKey(), entry.getValue().get(0), entry.getValue().get(1));
        }
    }

    public static void reverting(LinkedHashMap<String, ArrayList<Integer>> carsCollection, String[] command) {
        String car = command[1];
        int kilometers = Integer.parseInt(command[2]);

        int currentMileage = carsCollection.get(car).get(0);
        currentMileage -= kilometers;
        carsCollection.get(car).set(0, currentMileage);
        System.out.printf("%s mileage decreased by %d kilometers\n", car, kilometers);
        if (carsCollection.get(car).get(0) < 10000) {
            carsCollection.get(car).set(0, 10000);
        }
    }

    public static void refueling(LinkedHashMap<String, ArrayList<Integer>> carsCollection, String[] command) {
        String car = command[1];
        int fuel = Integer.parseInt(command[2]);

        int currentFuel = carsCollection.get(car).get(1);
        if (fuel + currentFuel > 75) {
            System.out.printf("%s refueled with %d liters\n", car, 75 - currentFuel);
            carsCollection.get(car).set(1, 75);
        } else {
            System.out.printf("%s refueled with %d liters\n", car, fuel);
            carsCollection.get(car).set(1, fuel + currentFuel);
        }
    }

    public static void driving(LinkedHashMap<String, ArrayList<Integer>> carsCollection, String[] command) {
        String car = command[1];
        int distance = Integer.parseInt(command[2]);
        int fuel = Integer.parseInt(command[3]);

        int fuelInTheCar = carsCollection.get(car).get(1);
        if (fuelInTheCar >= fuel) {
            int currentMileage = carsCollection.get(car).get(0);
            currentMileage += distance;
            carsCollection.get(car).set(0, currentMileage);
            carsCollection.get(car).set(1, fuelInTheCar - fuel);
            System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.\n", car, distance, fuel);
            if (currentMileage >= 100000) {
                carsCollection.remove(car);
                System.out.printf("Time to sell the %s!\n", car);
            }
        } else {
            System.out.println("Not enough fuel to make that ride");
        }
    }
}