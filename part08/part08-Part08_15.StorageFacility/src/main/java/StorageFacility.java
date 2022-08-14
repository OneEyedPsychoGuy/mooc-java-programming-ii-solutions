import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class StorageFacility {
    private Map<String, List<String>> units;

    public StorageFacility() {
        this.units = new HashMap<>();
    }

    public void add(String unit, String item) {
        this.units.putIfAbsent(unit, new ArrayList<>());
        this.units.get(unit).add(item);
    }

    public ArrayList<String> contents(String unit) {
        return (ArrayList<String>) this.units.getOrDefault(unit, new ArrayList<>());
    }

    public void remove(String unit, String item) {
        List<String> items = this.units.get(unit);

        if(items == null) {
            return;
        }

        items.remove(item);

        if(items.isEmpty()) {
            this.units.remove(unit);
        }
    }

    public ArrayList<String> storageUnits() {
        ArrayList<String> units = new ArrayList<>();

        for(String unit : this.units.keySet()) {
            if(!this.units.get(unit).isEmpty()) {
                units.add(unit);
            }
        }

        return units;
    }
}