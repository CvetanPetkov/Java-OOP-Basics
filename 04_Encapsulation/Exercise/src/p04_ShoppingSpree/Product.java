package p04_ShoppingSpree;

public class Product {
    private String name;
    private int cost;

    public Product(String name, int cost) {
        this.setName(name);
        this.setCost(cost);
    }

    public String getName() { return this.name; }
    public int getCost() { return this.cost; }

    private void setName(String name) {
        if (name == null || name.length() == 0 || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        } else {
            this.name = name;
        }
    }
    private void setCost(int cost) {
        if (cost < 0) {
            throw new IllegalArgumentException("Cost cannot be negative");
        } else {
            this.cost = cost;
        }
    }
}
