import java.util.List;
import java.util.ArrayList;

public class ChangeHistory {
    private List<Double> states;

    public ChangeHistory() {
        this.states = new ArrayList<>();
    }

    public void add(double state) {
        this.states.add(state);
    }

    public void clear() {
        this.states.clear();
    }

    public double minValue() {
        if(this.states.isEmpty()) return 0;

        double min = this.states.get(0);
        for(double state : this.states) {
            if(state < min) min = state;
        }

        return min;
    }

    public double maxValue() {
        if(this.states.isEmpty()) return 0;

        double max = this.states.get(0);
        for(double state : this.states) {
            if(state > max) max = state;
        }

        return max;
    }

    public double average() {
        if(this.states.isEmpty()) return 0;

        double sum = 0;
        for(double state : this.states) {
            sum += state;
        }

        return sum / this.states.size();
    }

    @Override
    public String toString() {
        return this.states.toString();
    }
}