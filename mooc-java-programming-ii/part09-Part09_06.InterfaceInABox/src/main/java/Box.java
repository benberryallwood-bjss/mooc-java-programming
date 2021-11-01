import java.util.ArrayList;
import java.util.List;

public class Box implements Packable {
    private double capacity;
    private List<Packable> contents;

    public Box(double capacity) {
        this.capacity = capacity;
        contents = new ArrayList<>();
    }

    public void add(Packable item) {
        if (weight() + item.weight() <= capacity) {
            contents.add(item);
        }
    }

    public double weight() {
        double weight = 0;
        for (Packable item : contents) {
            weight += item.weight();
        }
        return weight;
    }

    @Override
    public String toString() {
        return "Box: " + contents.size() + " items, total weight " + weight() + " kg";
    }
}
