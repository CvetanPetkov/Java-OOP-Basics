package p02_VehicleExtension;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.ROOT);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Vehicle> vehiclesList = new ArrayList<>();

        String[] input;
        for (int i = 0; i < 3; i++) {
            try {
                input = reader.readLine().split("[\\s]+");
                Vehicle vehicle = createVehicle(input);
                vehiclesList.add(vehicle);
            }
            catch (IllegalArgumentException error) {
                System.out.println(error.getMessage());
            }
        }

        int n = Integer.valueOf(reader.readLine());
        for (int i = 0; i < n; i++) {
            try {
                input = reader.readLine().split("[\\s]+");
                makeAction(input, vehiclesList);
            }
            catch (IllegalArgumentException error) {
                System.out.println(error.getMessage());
            }
        }

        for (Vehicle vehicle : vehiclesList) {
            System.out.println(vehicle.toString());
        }

    }

    private static void makeAction(String[] input, ArrayList<Vehicle> vehicles) {
        String action = input[0];
        String type = input[1];
        Double value = Double.valueOf(input[2]);
        switch (action) {
            case "Drive":
                for (Vehicle vehicle : vehicles) {
                    if (vehicle.getClass().getSimpleName().equals(type)) {
                        if (type.equals("Bus")) {
                            vehicle.tryDriveFull(value);
                        }
                        else {
                            vehicle.tryDrive(value);
                        }
                    }
                }
                break;
            case "Refuel":
                for (Vehicle vehicle : vehicles) {
                    if (vehicle.getClass().getSimpleName().equals(type)) {
                        vehicle.tryRefuel(value);
                    }
                }
                break;
            case "DriveEmpty":
                for (Vehicle vehicle : vehicles) {
                    if (vehicle.getClass().getSimpleName().equals(type)) {
                        vehicle.tryDrive(value);
                    }
                }
                break;
        }
    }

    private static Vehicle createVehicle(String[] input) {
        String type = input[0];
        Double fuel = Double.valueOf(input[1]);
        Double consumption = Double.valueOf(input[2]);
        Double capacity = Double.valueOf(input[3]);
        switch (type) {
            case "Car": return new Car(fuel, consumption, capacity);
            case "Truck": return new Truck(fuel, consumption, capacity);
            case "Bus": return new Bus(fuel, consumption, capacity);
        }
        return null;
    }
}