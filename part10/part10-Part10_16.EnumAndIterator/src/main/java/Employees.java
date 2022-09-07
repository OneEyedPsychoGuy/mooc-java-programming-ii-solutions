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
        Iterator<Person> employeeIterator = this.employees.iterator();
        while(employeeIterator.hasNext()) {
            System.out.println(employeeIterator.next());
        }
    }

    public void print(Education education) {
        Iterator<Person> employeeIterator = this.employees.iterator();
        while(employeeIterator.hasNext()) {
            Person employee = employeeIterator.next();
            if(employee.getEducation() == education) {
                System.out.println(employee);
            }
        }
    }

    public void fire(Education education) {
        Iterator<Person> employeeIterator = this.employees.iterator();
        while(employeeIterator.hasNext()) {
            if(employeeIterator.next().getEducation() == education) {
                employeeIterator.remove();
            }
        }
    }
}