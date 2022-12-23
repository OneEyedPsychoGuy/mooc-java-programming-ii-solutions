import java.util.List;
import java.util.ArrayList;

public class BoxWithMaxWeight extends Box {
    private List<Item> items;
    private int capacity;

    public BoxWithMaxWeight(int capacity) {
        this.items = new ArrayList<>();
        this.capacity = capacity;
    }

    private int getCurrentWeight() {
        int weight = 0;
        for(Item item : this.items) {
            weight += item.getWeight();
        }
        return weight;
    }

    @Override
    public void add(Item item) {
        if(item.getWeight() + this.getCurrentWeight() <= this.capacity) {
            this.items.add(item);
        }
    }

    @Override
    public boolean isInBox(Item item) {
        return this.items.contains(item);
    }
}