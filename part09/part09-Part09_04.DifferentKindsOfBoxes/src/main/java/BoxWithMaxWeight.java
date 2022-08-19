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
        int currentWeight = 0;
        for(Item item : this.items) {
            currentWeight += item.getWeight();
        }
        return currentWeight;
    }

    @Override
    public void add(Item item) {
        int newWeight = item.getWeight() + this.getCurrentWeight();
        if(newWeight <= this.capacity) {
            this.items.add(item);
        }
    }

    @Override
    public boolean isInBox(Item item) {
        return this.items.contains(item);
    }
}