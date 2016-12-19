package p04_ShoppingSpree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Person> listPerson = new LinkedList<>();
        Map<String, Product> mapProducts = new LinkedHashMap<>();
        Pattern pat = Pattern.compile("([a-zA-Z]*)=(-?[0-9]*)");

        // Adding Persons
        String input = reader.readLine();
        Matcher match = pat.matcher(input);
        try {
            while (match.find()) {
                String personName = match.group(1);
                int personMoney;
                try {
                    personMoney = Integer.parseInt(match.group(2));
                } catch (IllegalArgumentException iae) {
                    personMoney = -1;
                }

                if (match.group(2).isEmpty()) {
                    personMoney = -1;
                }
                Person person = new Person(personName, personMoney);
                listPerson.add(person);
            }
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }

        // Adding Products
        input = reader.readLine();
        match = pat.matcher(input);
        try {

            while (match.find()) {
                String productName = match.group(1);
                int productCost;
                try {
                    productCost = Integer.parseInt(match.group(2));
                } catch (IllegalArgumentException iae) {
                    productCost = -1;
                }

                if (match.group(2).isEmpty()) {
                    productCost = -1;
                }
                Product product = new Product(productName, productCost);
                mapProducts.put(productName, product);
            }
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }

        // Bying products
        while (true) {
            input = reader.readLine();
            if (input.equals("END")) {
                break;
            } else {
                String[] tokens = input.split("[\\s]+");
                String personName = tokens[0];
                String productName = tokens[1];
                for (Person person : listPerson) {
                    if (person.getName().equals(personName)) {
                        person.addProduct(person, mapProducts.get(productName));
                    }
                }
            }
        }

        // After END Printing
        for (Person person : listPerson) {
            if (person.getProducts().isEmpty()) {
                System.out.println(person.getName() + " - Nothing bought");
            } else {
                System.out.print(person.getName() + " - ");

                StringJoiner joiner = new StringJoiner(", ");
                person.getProducts().stream()
                        .forEach(p -> joiner.add(p.getName()));

                System.out.println(joiner);
            }
        }

    }
}
