public class Container {
    private int currentAmount;

    public Container() {
        currentAmount = 0;
    }

    public int contains() {
        return currentAmount;
    }

    public void add(int amount) {
        if (amount < 0) {
            return;
        }
        currentAmount += amount;
        if (currentAmount > 100) {
            currentAmount = 100;
        }
    }

    public void remove(int amount) {
        currentAmount -= amount;
        if (currentAmount < 0) {
            currentAmount = 0;
        }
    }

    @Override
    public String toString() {
        return currentAmount + "/100";
    }
}
