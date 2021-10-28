import java.util.ArrayList;

public class Hold {
    private int maxWeight;
    private ArrayList<Suitcase> items;

    public Hold(int maxWeight) {
        this.maxWeight = maxWeight;
        this.items = new ArrayList<>();
    }

    public void addSuitcase(Suitcase suitcase) {
        if (suitcase.totalWeight() + totalWeight() <= this.maxWeight) {
            this.items.add(suitcase);
        }
    }

    public int totalWeight() {
        int totalWeight = 0;
        for (Suitcase item : this.items) {
            totalWeight += item.totalWeight();
        }
        return totalWeight;
    }

    public void printItems() {
        for (Suitcase item : this.items) {
            item.printItems();
        }
    }

    public String toString() {
        return this.items.size() + " suitcases (" + totalWeight() + " kg)";
    }
}
