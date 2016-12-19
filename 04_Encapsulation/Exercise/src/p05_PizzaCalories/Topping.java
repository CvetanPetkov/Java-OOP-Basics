package p05_PizzaCalories;

public class Topping {
    private String type;
    private Double weight;
    private Double calories;
    private Pizza pizza;

    public Topping(String type, Double weight, Pizza pizza) {
        this.setType(type);
        this.setWeight(type, weight);
        this.setCalories(this.type, this.weight);
        this.setPizza(pizza);
    }

    public Double getCalories() {
        return this.calories;
    }

    private void setType(String type) {
        if (!type.equalsIgnoreCase("meat") && !type.equalsIgnoreCase("veggies") &&
                !type.equalsIgnoreCase("cheese") && !type.equalsIgnoreCase("sauce")) {
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", type));
        } else {
            this.type = type;
        }
    }
    private void setWeight(String type, Double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", type));
        } else {
            this.weight = weight;
        }
    }
    private void setCalories(String type, Double weight) {
        Double modifier = 0d;
        switch (type.toLowerCase()) {
            case "meat": modifier = 1.2d; break;
            case "veggies": modifier = 0.8d; break;
            case "cheese": modifier = 1.1d; break;
            case "sauce": modifier = 0.9d; break;
        }
        this.calories = 2* weight* modifier;
    }
    private void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public void addToppings(Topping topping, boolean isPizaa) {
        if (isPizaa) {
            this.pizza.addToppings(topping);
        }
    }
}
