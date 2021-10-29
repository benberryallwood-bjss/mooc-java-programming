import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VehicleRegistry {
    private HashMap<LicensePlate, String> vehicleHashMap;

    public VehicleRegistry() {
        vehicleHashMap = new HashMap<>();
    }

    public boolean add(LicensePlate licensePlate, String owner) {
        if (!(vehicleHashMap.get(licensePlate) == null)) {
            return false;
        }
        vehicleHashMap.put(licensePlate, owner);
        return true;
    }

    public String get(LicensePlate licensePlate) {
        return vehicleHashMap.get(licensePlate);
    }

    public boolean remove(LicensePlate licensePlate) {
        if (vehicleHashMap.get(licensePlate) == null) {
            return false;
        }
        vehicleHashMap.remove(licensePlate);
        return true;
    }

    public void printLicensePlates() {
        for (LicensePlate licensePlate : vehicleHashMap.keySet()) {
            System.out.println(licensePlate);
        }
    }

    public void printOwners() {
        List<String> ownersPrinted = new ArrayList<>();
        for (String owner : vehicleHashMap.values()) {
            if (!ownersPrinted.contains(owner)) {
                System.out.println(owner);
                ownersPrinted.add(owner);
            }
        }
    }
}
