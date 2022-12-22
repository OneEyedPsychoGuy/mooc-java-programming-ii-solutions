import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class Warehouse {
    private Map<String, Integer> productPrice;
    private Map<String, Integer> productStock;

    public Warehouse() {
        this.productPrice = new HashMap<>();
        this.productStock = new HashMap<>();
    }

    public Set<String> products() {
        return this.productPrice.keySet();
    }

    public int price(String product) {
        return this.productPrice.getOrDefault(product, -99);
    }

    public int stock(String product) {
        return this.productStock.getOrDefault(product, 0);
    }

    public void addProduct(String product, int price, int stock) {
        this.productPrice.put(product, price);
        this.productStock.put(product, stock);
    }

    public boolean take(String product) {
        int currentStock = this.productStock.getOrDefault(product, 0);
        if(currentStock <= 0) {
            return false;
        }

        this.productStock.put(product, currentStock - 1);
        return true;
    }
}