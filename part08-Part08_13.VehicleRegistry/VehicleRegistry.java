import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class VehicleRegistry {
    private HashMap<LicensePlate, String> plates;

    public VehicleRegistry() {
        this.plates = new HashMap<>();
    }

    public String get(LicensePlate plate) {
        return this.plates.get(plate);
    }

    public boolean add(LicensePlate plate, String owner) {
        if(!this.plates.containsKey(plate)) {
            this.plates.put(plate, owner);
            return true;
        }
        return false;
    }

    public boolean remove(LicensePlate plate) {
        if(this.plates.containsKey(plate)) {
            this.plates.remove(plate);
            return true;
        }
        return false;
    }

    public void printLicensePlates() {
        for(LicensePlate plate : this.plates.keySet()) {
            System.out.println(plate);
        }
    }

    public void printOwners() {
        List<String> owners = new ArrayList<>();

        for(String owner : this.plates.values()) {
            if(!owners.contains(owner)) {
                System.out.println(owner);
                owners.add(owner);
            }
        }
    }
}