import java.util.List;
import java.util.ArrayList;

public class Box implements Packable {
    private List<Packable> items;
    private double capacity;
    private double weight;

    public Box(double capacity) {
        this.items = new ArrayList<>();
        this.capacity = capacity;
        this.weight = 0;
    }

    public void add(Packable item) {
        double totalWeight = this.weight + item.weight();
        if(totalWeight <= capacity) {
            this.items.add(item);
            this.weight = totalWeight;
        }
    }

    @Override
    public double weight() {
        return this.weight;
    }

    @Override
    public String toString() {
        return "Box: " + this.items.size() + " items, total weight " + this.weight + " kg";
    }
}