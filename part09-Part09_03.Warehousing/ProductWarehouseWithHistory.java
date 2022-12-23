public class ProductWarehouseWithHistory extends ProductWarehouse {
    private ChangeHistory history;

    public ProductWarehouseWithHistory(String name, double capacity, double balance) {
        super(name, capacity);
        this.history = new ChangeHistory();

        this.addToWarehouse(balance);
    }

    public String history() {
        return this.history.toString();
    }

    public void printAnalysis() {
        System.out.println(
            "Product: " + this.getName() +
            "\nHistory: " + this.history() +
            "\nLargest amount of product: " + this.history.maxValue() +
            "\nSmallest amount of product: " + this.history.minValue() +
            "\nAverage: " + this.history.average()
        );
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