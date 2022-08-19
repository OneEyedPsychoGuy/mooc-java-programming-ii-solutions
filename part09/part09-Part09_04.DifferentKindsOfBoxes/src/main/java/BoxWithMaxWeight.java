import java.util.List;
import java.util.ArrayList;

public class BoxWithMaxWeight extends Box {
    private List<Item> items;
    private int capacity;
    private int weight;

    public BoxWithMaxWeight(int capacity) {
        this.items = new ArrayList<>();
        this.capacity = capacity;
        this.weight = 0;
    }

    @Override
    public void add(Item item) {
        int newWeight = this.weight + item.getWeight();

        if(newWeight <= capacity) {
            this.items.add(item);
            this.weight = newWeight;
        }
    }

    @Override
    public boolean isInBox(Item item) {
        return this.items.contains(item);
    }
}