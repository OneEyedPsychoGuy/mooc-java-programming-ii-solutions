public class Container {
    private static final int MIN = 0;
    private static final int MAX = 100;

    private int amount;

    public Container() {
        this.amount = 0;
    }

    public int contains() {
        return this.amount;
    }

    public void add(int amount) {
        if(amount < MIN) {
            return;
        }

        this.amount += amount;

        if(this.amount > MAX) {
            this.amount = 100;
        }
    }

    public void remove(int amount) {
        if(amount < MIN) {
            return;
        }

        this.amount -= amount;

        if(this.amount < MIN) {
            this.amount = 0;
        }
    }

    @Override
    public String toString() {
        return this.amount + "/" + MAX;
    }
}