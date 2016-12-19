package p08_Car;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

class Car {
    private Double speed;
    private Double fuel;
    private Double fuelEconomy;
    private Double distance;
    private String time;

    public Car (Double speed, Double fuel, Double fuelEconomy) {
        this.speed = speed;
        this.fuel = fuel;
        this.fuelEconomy = fuelEconomy;
        this.distance = 0d;
        this.time = null;
    }

    public void travelDistance (Double distance) {
        Double maxDistance = (this.fuel * 100d) / this.fuelEconomy;
        if (maxDistance < distance) {
            this.distance += maxDistance;
        } else {
            this.distance += distance;
        }
        this.fuel -= distance * (this.fuelEconomy / 100d);
        if (this.fuel < 0d) {
            this.fuel = 0d;
        }
    }

    public void refuel (Double fuel) {
        this.fuel += fuel;
    }

    public Double getTotalDistance () {
        return this.distance;
    }

    public Integer[] getTotalTime() {
        Double travelTime = this.distance / this.speed;
        Integer hours = travelTime.intValue();
        String[] timeToString = travelTime.toString().split("\\.");
        Integer minutes = Integer.valueOf(timeToString[1]);
        Integer[] time = new Integer[2];
        time[0] = hours;
        time[1] = minutes;
        return time;
    }

    public Double getFuel () {
        return this.fuel;
    }
}

public class p08_Car {
    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.ROOT);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = reader.readLine().split("[\\s]+");
        Double speed = Double.valueOf(tokens[0]);
        Double fuel = Double.valueOf(tokens[1]);
        Double fuelEconomy = Double.valueOf(tokens[2]);
        Car car = new Car(speed, fuel, fuelEconomy);

        while (true) {
            tokens = reader.readLine().split("[\\s]+");
            if (tokens[0].equals("END")) {
                break;
            } else {
                switch (tokens[0]) {
                    case "Travel":
                        Double distanceToTravel = Double.valueOf(tokens[1]);
                        car.travelDistance(distanceToTravel);
                        break;
                    case "Refuel":
                        Double newFuel = Double.valueOf(tokens[1]);
                        car.refuel(newFuel);
                        break;
                    case "Distance":
                        Double totalDistance = car.getTotalDistance();
                        System.out.printf("Total distance: %.1f kilometers\n", totalDistance);
                        break;
                    case "Time":
                        Integer[] time = car.getTotalTime();
                        Integer hours = time[0];
                        Integer minutes = time[1];
                        System.out.printf("Total time: %d hours and %d minutes\n",
                                hours, minutes);
                        break;
                    case "Fuel":
                        Double fuelLeft = car.getFuel();
                        System.out.printf("Fuel left: %.1f liters\n", fuelLeft);
                        break;
                }
            }
        }

    }
}
