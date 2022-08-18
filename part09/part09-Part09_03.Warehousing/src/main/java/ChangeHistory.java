import java.util.List;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.Collections;

public class ChangeHistory {
    private List<Double> history;

    public ChangeHistory() {
        this.history = new ArrayList<>();
    }

    public void add(double status) {
        this.history.add(status);
    }

    public void clear() {
        this.history.clear();
    }

    public double maxValue() {
        double max = Double.MIN_VALUE;

        for(double value : this.history) {
            if(value > max) max = value;
        }

        if(max == Double.MIN_VALUE) return 0;
        return max;
    }

    public double minValue() {
        double min = Double.MAX_VALUE;

        for(double value : this.history) {
            if(value < min) min = value;
        }

        if(min == Double.MAX_VALUE) return 0;
        return min;
    }

    public double average() {
        double sum = 0;

        for(double value : this.history) {
            sum += value;
        }

        return sum / this.history.size();
    }

    @Override
    public String toString() {
        return this.history.toString();
    }
}