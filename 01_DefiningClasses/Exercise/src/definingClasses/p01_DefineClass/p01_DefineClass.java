package definingClasses.p01_DefineClass;

import java.lang.reflect.Field;

class Person {
    String name;
    int age;
}

public class p01_DefineClass {
    public static void main(String[] args) throws Exception {
        Class person = Person.class;
        Field[] fields = person.getDeclaredFields();
        System.out.println(fields.length);

        Person pesho = new Person();
        pesho.name = "Pesho";
        pesho.age = 20;
        Person gosho = new Person();
        gosho.name = "Gosho";
        gosho.age = 18;
        Person stamat = new Person();
        stamat.name = "Stamat";
        stamat.age = 43;

        System.out.println(pesho.name + " " + pesho.age);
        System.out.println(gosho.name + " " + gosho.age);
        System.out.println(stamat.name + " " + stamat.age);
    }

}
