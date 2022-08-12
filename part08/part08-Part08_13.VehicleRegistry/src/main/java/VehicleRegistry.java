import java.util.HashMap;
import java.util.ArrayList;

public class VehicleRegistry {
    private HashMap<LicensePlate, String> licensePlates;

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

    public void printLicensePlates() {
        for(LicensePlate licensePlate : this.licensePlates.keySet()) {
            System.out.println(licensePlate);
        }
    }

    public void printOwners() {
        ArrayList<String> owners = new ArrayList<>();

        for(String owner : this.licensePlates.values()) {
            if(!owners.contains(owner)) {
                System.out.println(owner);
                owners.add(owner);
            }
        }
    }
}