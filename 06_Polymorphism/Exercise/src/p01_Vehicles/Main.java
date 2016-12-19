package p01_Vehicles;

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
        for (int i = 0; i < 2; i++) {
            input = reader.readLine().split("[\\s]+");
            Vehicle vehicle = createVehicle(input);
            vehiclesList.add(vehicle);
        }

        int n = Integer.valueOf(reader.readLine());
        for (int i = 0; i < n; i++) {
            input = reader.readLine().split("[\\s]+");
            makeAction(input, vehiclesList);
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
                        vehicle.tryDrive(value);
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
        }
    }

    private static Vehicle createVehicle(String[] input) {
        String type = input[0];
        Double fuel = Double.valueOf(input[1]);
        Double consumption = Double.valueOf(input[2]);
        switch (type) {
            case "Car": return new Car(fuel, consumption);
            case "Truck": return new Truck(fuel, consumption);
        }
        return null;
    }
}
