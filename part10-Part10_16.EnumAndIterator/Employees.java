import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Employees {
    private List<Person> employees;

    public Employees() {
        this.employees = new ArrayList<>();
    }

    public void add(Person person) {
        this.employees.add(person);
    }

    public void add(List<Person> people) {
        this.employees.addAll(people);
    }

    public void print() {
        Iterator<Person> iter = this.employees.iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    public void print(Education education) {
        Iterator<Person> iter = this.employees.iterator();
        while(iter.hasNext()) {
            Person employee = iter.next();
            if(employee.getEducation() == education) {
                System.out.println(employee);
            }
        }
    }

    public void fire(Education education) {
        Iterator<Person> iter = this.employees.iterator();
        while(iter.hasNext()) {
            if(iter.next().getEducation() == education) {
                iter.remove();
            }
        }
    }
}