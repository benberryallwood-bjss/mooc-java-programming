import java.util.ArrayList;
import java.util.HashMap;

public class StorageFacility {
    private HashMap<String, ArrayList<String>> storageFacility;

    public StorageFacility() {
        storageFacility = new HashMap<>();
    }

    public void add(String unit, String item) {
        storageFacility.putIfAbsent(unit, new ArrayList<>());
        storageFacility.get(unit).add(item);
    }

    public ArrayList<String> contents(String storageUnit) {
        if (!storageFacility.containsKey(storageUnit)) {
            return new ArrayList<>();
        }
        return storageFacility.get(storageUnit);
    }

    public void remove(String storageUnit, String item) {
        storageFacility.get(storageUnit).remove(item);
        if (storageFacility.get(storageUnit).isEmpty()) {
            storageFacility.remove(storageUnit);
        }
    }

    public ArrayList<String> storageUnits() {
        ArrayList<String> storageUnits = new ArrayList<>();
        storageUnits.addAll(storageFacility.keySet());
        return storageUnits;
    }
}
