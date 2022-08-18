import java.util.List;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.Collections;

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
        double max = Double.MIN_VALUE;

        for(double value : this.values) {
            if(value > max) max = value;
        }

        if(max == Double.MIN_VALUE) return 0;
        return max;
    }

    public double minValue() {
        double min = Double.MAX_VALUE;

        for(double value : this.values) {
            if(value < min) min = value;
        }

        if(min == Double.MAX_VALUE) return 0;
        return min;
    }

    public double average() {
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