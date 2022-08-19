public class OneItemBox extends Box {
    private Item item;

    @Override
    public void add(Item item) {
        if(this.item == null) {
            this.item = item;
        }
    }

    @Override
    public boolean isInBox(Item item) {
        if(this.item == null) {
            return false;
        }

        if(this.item.equals(item)) {
            return true;
        }

        return false;
    }
}