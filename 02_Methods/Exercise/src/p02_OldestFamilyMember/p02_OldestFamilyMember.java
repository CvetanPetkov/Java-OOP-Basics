package p02_OldestFamilyMember;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Person {
    private String name;
    private Integer age;

    public Person (String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public Integer getAge() {
        return this.age;
    }
}

class Family {
    List<Person> peoples;

    public Family () {
        this.peoples = new ArrayList<Person>();
    }

    public void addFamilyMember (Person person) {
        this.peoples.add(person);
    }

    public Person getOldestMember () {
        List<Person> buffer = peoples
                .stream()
                .sorted((p1, p2) -> p2.getAge()
                .compareTo(p1.getAge()))
                .collect(Collectors.toList());
        return buffer.get(0);
    }
}

public class p02_OldestFamilyMember {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        Family family = new Family();
        for (int i = 0; i < n; i++) {
            String[] item = reader.readLine().split("[\\s]+");
            String name = item[0];
            Integer age = Integer.parseInt(item[1]);
            Person person = new Person(name, age);
            family.addFamilyMember(person);
        }

        Method getOldestMethod = Family.class.getMethod("getOldestMember");
        Method addMemberMethod = Family.class.getMethod("addFamilyMember",Person.class);

        System.out.println(family.getOldestMember().getName() + " " + family.getOldestMember().getAge());
    }
}