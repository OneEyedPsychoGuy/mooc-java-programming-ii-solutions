import java.util.List;
import java.util.ArrayList;

public class Suitcase {
    private int maximumWeight;
    private List<Item> items;

    public Suitcase(int maximumWeight) {
        this.items = new ArrayList<>();
        this.maximumWeight = maximumWeight;
    }

    public void addItem(Item item) {
        if (this.totalWeight() + item.getWeight() > this.maximumWeight) {
            return;
        }
        this.items.add(item);
    }

    public int totalWeight() {
        return this.items.stream()
                .mapToInt(item -> item.getWeight())
                .reduce(0, (sum, weight) -> sum + weight);
    }

    public void printItems() {
        this.items.forEach(System.out::println);
    }

    public Item heaviestItem() {
        if (this.items.isEmpty()) {
            return null;
        }
        return this.items.stream()
                .max((t1, t2) -> t1.getWeight() - t2.getWeight())
                .get();
    }

    @Override
    public String toString() {
        if (this.items.isEmpty()) {
            return "no items (0 kg)";
        }

        if (this.items.size() == 1) {
            return "1 item (" + this.totalWeight() + " kg)";
        }

        return this.items.size() + " items (" + this.totalWeight() + " kg)";
    }
}
