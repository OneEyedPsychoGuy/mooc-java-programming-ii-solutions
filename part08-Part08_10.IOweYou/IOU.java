import java.util.HashMap;

public class IOU {
    private HashMap<String, Double> debt;

    public IOU() {
        this.debt = new HashMap<>();
    }

    public void setSum(String to, double amount) {
        this.debt.put(to, amount);
    }

    public double howMuchDoIOweTo(String to) {
        return this.debt.getOrDefault(to, 0.0);
    }
}