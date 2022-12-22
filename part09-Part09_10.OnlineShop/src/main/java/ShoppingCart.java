import java.util.List;
import java.util.ArrayList;

public class ShoppingCart {
    private List<Item> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void add(String product, int price) {
        for(Item item : this.items) {
            if(item.getName().equals(product)) {
                item.increaseQuantity();
                return;
            }
        }

        this.items.add(new Item(product, 1, price));
    }

    public int price() {
        int price = 0;
        for(Item item : this.items) {
            price += item.price();
        }
        return price;
    }

    public void print() {
        this.items.forEach(System.out::println);
    }
}