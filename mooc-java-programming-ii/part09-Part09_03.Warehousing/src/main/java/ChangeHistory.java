import java.util.ArrayList;
import java.util.List;

public class ChangeHistory {
    private List<Double> changeHistory;

    public ChangeHistory() {
        changeHistory = new ArrayList<>();
    }

    public void add(double status) {
        changeHistory.add(status);
    }

    public void clear() {
        changeHistory.clear();
    }

    public double maxValue() {
        if (changeHistory.isEmpty()) {
            return 0;
        }
        double maxValue = changeHistory.get(0);
        for (Double value : changeHistory) {
            if (value > maxValue) {
                maxValue = value;
            }
        }
        return maxValue;
    }

    public double minValue() {
        if (changeHistory.isEmpty()) {
            return 0;
        }
        double minValue = changeHistory.get(0);
        for (Double value : changeHistory) {
            if (value < minValue) {
                minValue = value;
            }
        }
        return minValue;
    }

    public double average() {
        if (changeHistory.isEmpty()) {
            return 0;
        }
        double total = 0;
        for (Double value : changeHistory) {
            total += value;
        }
        return total / changeHistory.size();
    }

    @Override
    public String toString() {
        return changeHistory.toString();
    }
}
