package p05_PizzaCalories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static List<Dough> doughList = new ArrayList<>();
    static Topping topping;
    static Pizza pizza;
    static String pizzaName;
    static int number = 0;
    static boolean isPizza = false;
    static boolean isTopping = false;

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.ROOT);


        try {
            String[] input = reader.readLine().split("[\\s]+");
            while (!input[0].equals("END")) {
                String caller = input[0];
                switch (caller) {
                    case "Pizza":
                        isPizza = true;
                        pizzaName = input[1];
                        number = Integer.valueOf(input[2]);
                        checkToppings(number);
                        break;
                    case "Dough": makeDough(input); break;
                    case "Topping": isTopping = true; makeTopping(input); break;
                }
                input = reader.readLine().split("[\\s]+");
            }

            makePizza();
            if (isPizza) {
                pizza.getPrintOut();
            }
//            else if (isTopping) {
//                System.out.printf("%.2f\n", doughList.get(0).getCalories());
//                System.out.printf("%.2f", topping.getCalories());
//            } else if (!isPizza && !isTopping){
//                System.out.printf("%.2f", doughList.get(0).getCalories());
//            }

        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void checkToppings(int number) {
        if (number > 10) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
    }

    private static void makePizza() {
        pizza = new Pizza(pizzaName, doughList.get(0));
    }

    private static void makeTopping(String[] input)  {
            String toppingType = input[1];
            Double weight = Double.valueOf(input[2]);
            topping = new Topping(toppingType, weight, pizza);
            topping.addToppings(topping, isPizza);
        if (!isPizza) {
            System.out.printf("%.2f\n", topping.getCalories());
        }
    }

    private static void makeDough(String[] input) {
        String doughType = input[1];
        String technique = input[2];
        Double weight = Double.valueOf(input[3]);
        Dough dough = new Dough(doughType, technique, weight);
        doughList.add(dough);
        if (!isPizza && !isTopping) {
            System.out.printf("%.2f\n", doughList.get(0).getCalories());
        }
    }
}
