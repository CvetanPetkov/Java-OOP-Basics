package p01_Person;

public class Child extends Person{

    public Child(String name, Integer age) {
        super(name, age);
    }

    @Override
    protected void setAge(Integer age) {
        if (age > 15) {
            throw new IllegalArgumentException("Child's age must be lesser than 15!");
        } else {
            super.setAge(age);
        }
    }

}
