
import java.util.ArrayList;
import java.util.List;

public class Suitcase {

    private int maximumWeight;
    private List<Item> items;

    public Suitcase(int maximumWeight) {
        items = new ArrayList<>();
        this.maximumWeight = maximumWeight;
    }

    public void addItem(Item item) {
        if (totalWeight() + item.getWeight() > maximumWeight) {
            return;
        }

        items.add(item);
    }

    public int totalWeight() {
        return items.stream()
                .mapToInt(item -> item.getWeight())
                .reduce(0, (currentSum, value) -> currentSum + value);
    }

    public void printItems() {
        items.forEach(System.out::println);
    }

    public Item heaviestItem() {
        if (items.isEmpty()) {
            return null;
        }

        return items.stream()
                .max((t1, t2) -> t1.getWeight() - t2.getWeight())
                .get();
    }

    @Override
    public String toString() {
        if (items.isEmpty()) {
            return "no items (0 kg)";
        }

        if (items.size() == 1) {
            return "1 item (" + totalWeight() + " kg)";
        }

        return items.size() + " items (" + totalWeight() + " kg)";
    }
}
