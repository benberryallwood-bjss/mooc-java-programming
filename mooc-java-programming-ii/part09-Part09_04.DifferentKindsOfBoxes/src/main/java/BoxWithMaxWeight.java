import java.util.ArrayList;
import java.util.List;

public class BoxWithMaxWeight extends Box {
    private int capacity;
    private List<Item> contents;

    public BoxWithMaxWeight(int capacity) {
        this.capacity = capacity;
        contents = new ArrayList<>();
    }

    private int totalWeight() {
        int total = 0;
        for (Item item : contents) {
            total += item.getWeight();
        }
        return total;
    }

    public void add(Item item) {
        if (totalWeight() + item.getWeight() <= capacity) {
            contents.add(item);
        }
    }

    @Override
    public boolean isInBox(Item item) {
        return contents.contains(item);
    }
}
