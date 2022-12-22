import java.util.HashMap;

public class IOU {
    private HashMap<String, Double> iou;

    public IOU() {
        this.iou = new HashMap<>();
    }

    public void setSum(String to, double amount) {
        this.iou.put(to, amount);
    }

    public double howMuchDoIOweTo(String to) {
        return this.iou.getOrDefault(to, 0.0);
    }
}