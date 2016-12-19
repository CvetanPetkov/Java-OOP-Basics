package p02_CreatingConstructors;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;

class Person1 {
    //static String DEFAULT_NAME = "No name";
    
    String name;
    int age;

    Person1() {
        this("No name", 1);
        //this(DEFAULT_NAME, 1);
    }

    Person1(int age) {
        this("No name", age);
    }

    Person1(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class p02_CreatingConstructors {
    public static void main(String[] args) throws Exception {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(isr);
        Class personClass = Person1.class;
        Constructor emptyCtor = personClass.getDeclaredConstructor();
        Constructor ageCtor = personClass.getDeclaredConstructor(int.class);
        Constructor nameAgeCtor = personClass
                .getDeclaredConstructor(String.class, int.class);

        String name = reader.readLine();
        int age = Integer.parseInt(reader.readLine());

        Person1 basePerson = (Person1) emptyCtor.newInstance();
        Person1 personWithAge = (Person1) ageCtor.newInstance(age);
        Person1 personFull = (Person1) nameAgeCtor.newInstance(name, age);

        System.out.printf("%s %s%n", basePerson.name, basePerson.age);
        System.out.printf("%s %s%n", personWithAge.name, personWithAge.age);
        System.out.printf("%s %s%n", personFull.name, personFull.age);
    }

}
