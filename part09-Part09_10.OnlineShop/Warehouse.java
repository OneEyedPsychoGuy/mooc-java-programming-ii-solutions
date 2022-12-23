import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class Warehouse {
    private Map<String, Integer> prices;
    private Map<String, Integer> quantities;

    public Warehouse() {
        this.prices = new HashMap<>();
        this.quantities = new HashMap<>();
    }

    public Set<String> products() {
        return this.prices.keySet();
    }

    public int price(String product) {
        return this.prices.getOrDefault(product, -99);
    }

    public int stock(String product) {
        return this.quantities.getOrDefault(product, 0);
    }

    public void addProduct(String product, int price, int quantity) {
        this.prices.put(product, price);
        this.quantities.put(product, quantity);
    }

    public boolean take(String product) {
        int quantity = this.quantities.getOrDefault(product, 0);
        if(quantity <= 0) {
            return false;
        }

        this.quantities.put(product, quantity - 1);
        return true;
    }
}