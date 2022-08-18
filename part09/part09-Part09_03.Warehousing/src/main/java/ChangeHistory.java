import java.util.List;
import java.util.ArrayList;

public class ChangeHistory {
    private List<Double> values;

    public ChangeHistory() {
        this.values = new ArrayList<>();
    }

    public void add(double status) {
        this.values.add(status);
    }

    public void clear() {
        this.values.clear();
    }

    public double maxValue() {
        if(this.values.isEmpty()) return 0;

        double max = this.values.get(0);
        for(double value : this.values) {
            if(value > max) max = value;
        }

        return max;
    }

    public double minValue() {
        if(this.values.isEmpty()) return 0;

        double min = this.values.get(0);
        for(double value : this.values) {
            if(value < min) min = value;
        }

        return min;
    }

    public double average() {
        if(this.values.isEmpty()) return 0;

        double sum = 0;
        for(double value : this.values) {
            sum += value;
        }

        return sum / this.values.size();
    }

    @Override
    public String toString() {
        return this.values.toString();
    }
}