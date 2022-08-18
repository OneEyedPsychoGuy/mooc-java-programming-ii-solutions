public class ProductWarehouseWithHistory extends ProductWarehouse {
    private ChangeHistory history;

    public ProductWarehouseWithHistory(String productName, double capacity, double initialBalance) {
        super(productName, capacity);
        this.history = new ChangeHistory();

        this.addToWarehouse(initialBalance);
    }

    public String history() {
        return this.history.toString();
    }

    @Override
    public void addToWarehouse(double amount) {
        super.addToWarehouse(amount);
        this.history.add(this.getBalance());
    }

    @Override
    public double takeFromWarehouse(double amount) {
        double removed = super.takeFromWarehouse(amount);
        this.history.add(this.getBalance());
        return removed;
    }
}