import java.util.List;
import java.util.ArrayList;

public class MisplacingBox extends Box {
    private List<Item> items;

    public MisplacingBox() {
        this.items = new ArrayList<>();
    }

    @Override
    public void add(Item item) {
        this.items.add(item);
    }
    
    @Override
    public boolean isInBox(Item item) {
        return false;
    }
}