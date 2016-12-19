package p04_ShoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private int money;
    private List<Product> products;

    public Person(String name, int money) {
        this.setName(name);
        this.setMoney(money);
        this.setProducts();
    }

    public String getName() { return this.name; }
    public int getMoney() { return this.money; }
    public List<Product> getProducts() { return this.products; }

    private void setName(String name) {
        if (name == null || name.length() == 0 || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        } else {
            this.name = name;
        }
    }
    private void setMoney(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        } else {
            this.money = money;
        }
    }
    private void setProducts() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Person person, Product product) {
        if (person.getMoney() >= product.getCost()) {
            this.products.add(product);
            this.money -= product.getCost();
            System.out.println(this.getName() + " bought " + product.getName());
        } else {
            System.out.println(this.getName() + " can't afford " + product.getName());
        }
    }
}
