import java.util.List;
import java.util.ArrayList;

public class Box implements Packable {
    private List<Packable> items;
    private double capacity;

    public Box(double capacity) {
        this.items = new ArrayList<>();
        this.capacity = capacity;
    }

    public void add(Packable item) {
        double weight = this.weight() + item.weight();
        if(weight <= capacity) {
            this.items.add(item);
        }
    }

    @Override
    public double weight() {
        double weight = 0;
        for(Packable item : this.items) {
            weight += item.weight();
        }
        return weight;
    }

    @Override
    public String toString() {
        return "Box: " + this.items.size() + " items, total weight " + this.weight() + " kg";
    }
}