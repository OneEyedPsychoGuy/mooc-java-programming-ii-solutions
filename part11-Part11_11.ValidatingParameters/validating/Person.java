package validating;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        if(name == null || name.isEmpty() || name.length() > 40 || age < 0 || age > 120) {
            throw new IllegalArgumentException("Name was null, empty, or above 40 characters in length!");
        }

        if(age < 0 || age > 120) {
            throw new IllegalArgumentException("Age must be between 0-120!");
        }

        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}