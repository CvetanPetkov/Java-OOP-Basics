package p05_PizzaCalories;


import java.util.ArrayList;
import java.util.List;

import static p05_PizzaCalories.Main.pizza;

public class Pizza {
    private String name;
    private Dough dough;
    private static List<Topping> toppings;

    public Pizza(String name, Dough dough) {
        this.setName(name);
        this.setDough(dough);
        this.toppings = new ArrayList<Topping>();
    }

    public String getName() {
        return this.name;
    }

    public Double getCalories() {
        Double totalCalories = this.dough.getCalories();
        for (Topping topping : toppings) {
            totalCalories += topping.getCalories();
        }
        return totalCalories;
    }
    public void getPrintOut() {
        System.out.printf("%s - %.2f Calories.", pizza.getName(), pizza.getCalories());
    }

    private void setName(String name) {
        if (name.isEmpty() || name == null || name.trim().length() == 0 || name.length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols");
        } else {
            this.name = name;
        }
    }
    private void setDough(Dough dough) {
        this.dough = dough;
    }


    public void addToppings(Topping toping) {
            this.toppings.add(toping);
    }
}
