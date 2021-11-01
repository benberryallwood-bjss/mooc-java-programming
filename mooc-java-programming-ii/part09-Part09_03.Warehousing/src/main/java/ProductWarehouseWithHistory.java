public class ProductWarehouseWithHistory extends ProductWarehouse {
    private ChangeHistory changeHistory;

    public ProductWarehouseWithHistory(String productName, double capacity, double initialBalance) {
        super(productName, capacity);
        super.addToWarehouse(initialBalance);
        changeHistory = new ChangeHistory();
        changeHistory.add(initialBalance);
    }

    public void addToWarehouse(double amount) {
        super.addToWarehouse(amount);
        changeHistory.add(getBalance());
    }

    public double takeFromWarehouse(double amount) {
        double amountTaken = super.takeFromWarehouse(amount);
        changeHistory.add(getBalance());
        return amountTaken;
    }

    public void printAnalysis() {
        System.out.println(
                "Product: " + getName()
                + "History: " + changeHistory
                + "Largest amount of product: " + changeHistory.maxValue()
                + "Smallest amount of product: " + changeHistory.minValue()
                + "Average: " + changeHistory.average()
        );

    }

    public String history() {
        return changeHistory.toString();
    }
}
