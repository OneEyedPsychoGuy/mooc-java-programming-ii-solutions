import java.util.List;
import java.util.ArrayList;

public class Employees {
    private List<Person> persons;

    public Employees() {
        this.persons = new ArrayList<>();
    }

    public void add(Person person) {
        this.persons.add(person);
    }

    public void add(List<Person> people) {
        this.persons.addAll(people);
    }

    public void print() {
        this.persons.forEach(System.out::println);
    }

    public void print(Education education) {
        this.persons.forEach(person -> {
            if(person.getEducation() == education) {
                System.out.println(person);
            }
        });
    }
}