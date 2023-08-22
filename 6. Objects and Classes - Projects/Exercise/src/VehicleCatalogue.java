import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class VehicleCatalogue {
    static class Vehicle {
        private String typeOfVehicle;
        private String model;
        private String color;
        private int horsepower;

        Vehicle(String typeOfVehicle, String model, String color, int horsepower) {
            this.typeOfVehicle = typeOfVehicle;
            this.model = model;
            this.color = color;
            this.horsepower = horsepower;
        }

        public void setTypeOfVehicle(String typeOfVehicle) {
            this.typeOfVehicle = typeOfVehicle;
        }

        public String getTypeOfVehicle() {
            return this.typeOfVehicle;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getModel() {
            return model;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getColor() {
            return color;
        }

        public void setHorsepower(int horsepower) {
            this.horsepower = horsepower;
        }

        public int getHorsepower() {
            return horsepower;
        }

//        @Override
//        public String toString() {
//            return String.format("Type: %s\nModel: %s\nColor: %s\nHorsepower: %d\n", getTypeOfVehicle(), getModel(), getColor(), getHorsepower());
//        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Vehicle> vehicles = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] token = input.split(" ");
            String typeOfVehicle = token[0];
            String model = token[1];
            String color = token[2];
            int horsepower = Integer.parseInt(token[3]);

            Vehicle vehicle = new Vehicle(typeOfVehicle, model, color, horsepower);
            vehicles.add(vehicle);

            input = scanner.nextLine();
        }

        String model = scanner.nextLine();
        while (!model.equals("Close the Catalogue")) {
            for (Vehicle vehicle : vehicles) {
                if (model.equals(vehicle.getModel())) {
                    String typeOfVehicle = "";
                    if (vehicle.getTypeOfVehicle().equals("car")) {
                        typeOfVehicle = "Car";
                    } else if (vehicle.getTypeOfVehicle().equals("truck")) {
                        typeOfVehicle = "Truck";
                    }

                    System.out.printf("Type: %s\n", typeOfVehicle);
                    System.out.printf("Model: %s\n", vehicle.getModel());
                    System.out.printf("Color: %s\n", vehicle.getColor());
                    System.out.printf("Horsepower: %d\n", vehicle.getHorsepower());
                    break;
                }
            }
            model = scanner.nextLine();
        }

        double carsTotalHP = 0;
        int carsCounter = 0;
        double trucksTotalHP = 0;
        int trucksCounter = 0;

        for (Vehicle vehicle : vehicles) {
            if (vehicle.getTypeOfVehicle().equals("car")) {
                carsTotalHP += vehicle.getHorsepower();
                carsCounter++;
            } else if (vehicle.getTypeOfVehicle().equals("truck")) {
                trucksTotalHP += vehicle.getHorsepower();
                trucksCounter++;
            }
        }

        double carsAvgHP = carsTotalHP / carsCounter;
        if (Double.isNaN(carsAvgHP)) {
            carsAvgHP = 0;
        }
        double trucksAvgHP = trucksTotalHP / trucksCounter;
        if (Double.isNaN(trucksAvgHP)) {
            trucksAvgHP = 0;
        }
        System.out.printf("Cars have average horsepower of: %.2f.\n", carsAvgHP);
        System.out.printf("Trucks have average horsepower of: %.2f.\n", trucksAvgHP);
    }
}