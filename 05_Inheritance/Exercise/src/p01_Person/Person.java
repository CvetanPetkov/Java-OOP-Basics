package p01_Person;

public class Person {
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.setName(name);
        this.setAge(age);
    }

    public String getName() {
        return this.name;
    }
    public int getAge() {
        return this.age;
    }

    private void setName(String name) {
        if (name.length() <= 3) {
            throw new IllegalArgumentException("Name's length should not be less than 3 symbols!");
        } else {
            this.name = name;
        }

    }
    protected void setAge(Integer age) {
        if (age < 1) {             // || age > 15 for children
            throw new IllegalArgumentException("Age must be positive!");
        } else {
            this.age = age;
        }
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Name: %s, Age: %d",
                this.getName(), this.getAge()));
        return stringBuilder.toString();
    }
}
