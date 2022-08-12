import java.util.Map;
import java.util.HashMap;

public class VehicleRegistry {
    private Map<LicensePlate, String> licensePlates;

    public VehicleRegistry() {
        this.licensePlates = new HashMap<>();
    }

    public boolean add(LicensePlate licensePlate, String owner) {
        if(!this.licensePlates.containsKey(licensePlate)) {
            this.licensePlates.put(licensePlate, owner);
            return true;
        }
        return false;
    }

    public String get(LicensePlate licensePlate) {
        return this.licensePlates.get(licensePlate);
    }

    public boolean remove(LicensePlate licensePlate) {
        if(this.licensePlates.containsKey(licensePlate)) {
            this.licensePlates.remove(licensePlate);
            return true;
        }
        return false;
    }
}