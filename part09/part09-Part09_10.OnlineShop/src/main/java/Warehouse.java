import java.util.Map;
import java.util.HashMap;

public class Warehouse {
    private Map<String, Integer> productPrice;

    public Warehouse() {
        this.productPrice = new HashMap<>();
    }

    public void addProduct(String product, int price, int stock) {
        this.productPrice.put(product, price);
    }

    public int price(String product) {
        return this.productPrice.getOrDefault(product, -99);
    }
}