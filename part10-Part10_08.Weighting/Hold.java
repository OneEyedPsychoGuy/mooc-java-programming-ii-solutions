import java.util.List;
import java.util.ArrayList;

public class Hold {
    private List<Suitcase> suitcases;
    private int maxWeight;

    public Hold(int maxWeight) {
        this.maxWeight = maxWeight;
        this.suitcases = new ArrayList<>();
    }

    public void addSuitcase(Suitcase suitcase) {
        if(this.totalWeight() + suitcase.totalWeight() <= maxWeight) {
            this.suitcases.add(suitcase);
        }
    }

    public int totalWeight() {
        return this.suitcases.stream()
            .mapToInt(s -> s.totalWeight())
            .sum();
    }

    public void printItems() {
        this.suitcases.stream()
            .forEach(s -> s.printItems());
    }

    @Override
    public String toString() {
        if(this.suitcases.isEmpty()) {
            return "no suitcases (0 kg)";
        }
        return this.suitcases.size() + " suitcase" + (this.suitcases.size() == 1 ? "" : "s") + " (" + this.totalWeight() + " kg)";
    }
}
