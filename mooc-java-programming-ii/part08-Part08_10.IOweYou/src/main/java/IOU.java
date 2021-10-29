import java.util.HashMap;

public class IOU {
    private HashMap<String, Double> iOUs;

    public IOU() {
        iOUs = new HashMap<>();
    }

    public void setSum(String toWhom, double amount) {
        iOUs.put(toWhom, amount);
    }

    public double howMuchDoIOweTo(String toWhom) {
        return iOUs.getOrDefault(toWhom, 0.0);
    }
}
