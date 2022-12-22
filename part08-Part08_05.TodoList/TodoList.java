import java.util.List;
import java.util.ArrayList;

public class TodoList {
    private List<String> tasks;

    public TodoList() {
        this.tasks = new ArrayList<>();
    }

    public void add(String task) {
        tasks.add(task);
    }

    public void remove(int num) {
        tasks.remove(num - 1);
    }

    public void print() {
        for(int i = 1; i <= tasks.size(); i++) {
            System.out.println(i + ": " + tasks.get(i - 1));
        }
    }
}