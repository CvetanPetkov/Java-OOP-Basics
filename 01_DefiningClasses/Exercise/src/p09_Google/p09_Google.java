package p09_Google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Person {
    String name;
    Company company;
    List<Pokemon> pokemons;
    List<Parents> parents;
    List<Children> childrens;
    Car car;

    Person (String name) {
        this.name = name;
        this.company = new Company("", "", 0d);
        this.pokemons = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.childrens = new ArrayList<>();
        this.car = new Car("", "");
    }
        }
class Company {
    String name;
    String department;
    Double salary;

    Company (String name, String department, Double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
}
class Pokemon {
    String name;
    String type;

    Pokemon (String name, String type) {
        this.name = name;
        this.type = type;
    }
}
class Parents {
    String name;
    String birthday;

    Parents (String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }
}
class Children {
    String name;
    String birthday;

    Children (String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }
}
class Car {
    String model;
    String speed;

    Car (String model, String speed) {
        this.model = model;
        this.speed = speed;
    }
}

public class p09_Google {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Person> personMap = new HashMap<>();

        while (true) {
            String input = reader.readLine();
            if (input.equals("End")) {
                break;
            } else {
                String[] tokens = input.split("[\\s]+");
                String personName = tokens[0];
                switch (tokens[1]) {
                    case "company":
                        String companyName = tokens[2];
                        String department = tokens[3];
                        Double salary = Double.parseDouble(tokens[4]);
                        if (!personMap.containsKey(personName)) {
                            Company company = new Company(companyName, department, salary);
                            Person person = new Person(personName);
                            person.company = company;
                            personMap.put(personName, person);
                        } else {
                            Company company = new Company(companyName, department, salary);
                            personMap.get(personName).company = company;
                        }
                        break;
                    case "pokemon":
                        String pokemonName = tokens[2];
                        String pokemonType = tokens[3];
                        if (!personMap.containsKey(personName)) {
                            Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                            Person person = new Person(personName);
                            person.pokemons.add(pokemon);
                            personMap.put(personName, person);
                        } else {
                            Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                            personMap.get(personName).pokemons.add(pokemon);
                        }
                        break;
                    case "parents":
                        String parentName = tokens[2];
                        String parentBirthday = tokens[3];
                        if (!personMap.containsKey(personName)) {
                            Parents parent = new Parents(parentName, parentBirthday);
                            Person person = new Person(personName);
                            person.parents.add(parent);
                            personMap.put(personName, person);
                        } else {
                            Parents parent = new Parents(parentName, parentBirthday);
                            personMap.get(personName).parents.add(parent);
                        }
                        break;
                    case "children":
                        String childrenName = tokens[2];
                        String childrenBirthday = tokens[3];
                        if (!personMap.containsKey(personName)) {
                            Children children = new Children(childrenName, childrenBirthday);
                            Person person = new Person(personName);
                            person.childrens.add(children);
                            personMap.put(personName, person);
                        } else {
                            Children children = new Children(childrenName, childrenBirthday);
                            personMap.get(personName).childrens.add(children);
                        }
                        break;
                    case "car":
                        String carModel = tokens[2];
                        String carSpeed = tokens[3];
                        if (!personMap.containsKey(personName)) {
                            Car car = new Car(carModel, carSpeed);
                            Person person = new Person(personName);
                            person.car = car;
                            personMap.put(personName, person);
                        } else {
                            Car car = new Car(carModel, carSpeed);
                            personMap.get(personName).car = car;
                        }
                        break;
                }
            }
        }

        String nameToPrint = reader.readLine();
        System.out.println(nameToPrint);
        System.out.println("Company:");
        if (personMap.get(nameToPrint).company.name !="") {
            System.out.printf("%s %s %.2f\n",
                    personMap.get(nameToPrint).company.name,
                    personMap.get(nameToPrint).company.department,
                    personMap.get(nameToPrint).company.salary);
        }
        System.out.println("Car:");
        if (personMap.get(nameToPrint).car.model != "") {
            System.out.println(personMap.get(nameToPrint).car.model + " " +
                    personMap.get(nameToPrint).car.speed);
        }
        System.out.println("Pokemon:");
        for (Pokemon pokemon : personMap.get(nameToPrint).pokemons) {
            System.out.println(pokemon.name + " " + pokemon.type);
        }
        System.out.println("Parents:");
        for (Parents parent : personMap.get(nameToPrint).parents) {
            System.out.println(parent.name + " " + parent.birthday);
        }
        System.out.println("Children:");
        for (Children children : personMap.get(nameToPrint).childrens) {
            System.out.println(children.name + " " + children.birthday);
        }
    }
}
