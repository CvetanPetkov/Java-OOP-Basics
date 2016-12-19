package p07_CarSalesman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Car {
    String model;
    Engine engine;
    String weight;
    String color;

    Car (String model, Engine engine, String weight, String color){
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }
}

class Engine {
    String model;
    int power;
    String displacement;
    String efficiency;

    Engine (String model, int power, String displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }
}

public class p07_CarSalesman {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<Engine> enginesList = new ArrayList<>();
        List<Car> carsList = new ArrayList<>();

        String[] input;
        for (int i = 0; i < n; i++) {
            input = reader.readLine().split("[\\s]+");
            String model = input[0];
            int power = Integer.parseInt(input[1]);
            String displacement = "n/a";
            String efficiency = "n/a";
            if (input.length > 2) {
                if (input[2].matches("[0-9]+")) {
                    displacement = input[2];
                } else {
                    efficiency = input[2];
                }
            }
            if (input.length > 3) {
                efficiency = input[3];
            }

            Engine engine = new Engine(model, power, displacement, efficiency);
            enginesList.add(engine);
        }

        n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            input = reader.readLine().split("[\\s]+");
            String model = input[0];
            String currEngine = input[1];
            String weight = "n/a";
            String color = "n/a";
            if (input.length > 2) {
                if (input[2].matches("[0-9]+")) {
                    weight = input[2];
                } else {
                    color = input[2];
                }
            }
            if (input.length > 3) {
                color = input[3];
            }

            for (Engine engine : enginesList) {
                if (currEngine.equals(engine.model)) {
                    Car car = new Car(model, engine, weight, color);
                    carsList.add(car);
                }
            }
        }

        for (Car car : carsList) {
            printCar (car);
        }
    }

    private static void printCar(Car car) {
        System.out.printf("%s:\n\t%s:\n\t\tPower: %d\n\t\tDisplacement: %s\n\t\tEfficiency: %s\n\tWeight: %s\n\tColor: %s\n",
                car.model, car.engine.model, car.engine.power, car.engine.displacement, car.engine.efficiency,
                car.weight, car.color);
    }
}
