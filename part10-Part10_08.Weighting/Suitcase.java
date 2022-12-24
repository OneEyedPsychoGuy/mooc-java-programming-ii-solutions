import java.util.List;
import java.util.ArrayList;

public class Suitcase {
    private List<Item> items;
    private int maxWeight;

    public Suitcase(int maxWeight) {
        this.items = new ArrayList<>();
        this.maxWeight = maxWeight;
    }

    public void addItem(Item item) {
        if(this.totalWeight() + item.getWeight() <= this.maxWeight) {
            this.items.add(item);
        }
    }

    public int totalWeight() {
        return this.items.stream()
            .mapToInt(i -> i.getWeight())
            .sum();
    }

    public Item heaviestItem() {
        if (this.items.isEmpty()) {
            return null;
        }
        return this.items.stream()
            .max((i1, i2) -> i1.getWeight() - i2.getWeight())
            .get();
    }

    public void printItems() {
        this.items.stream()
            .forEach(System.out::println);
    }

    @Override
    public String toString() {
        if(this.items.isEmpty()) {
            return "no items (0 kg)";
        }
        return this.items.size() + " item" + (this.items.size() == 1 ? "" : "s") + " (" + this.totalWeight() + " kg)";
    }
}
