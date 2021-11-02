

import java.util.ArrayList;

public class Hold {

    private ArrayList<Suitcase> suitcases;
    private int maximumWeight;

    public Hold(int maximumWeight) {
        this.maximumWeight = maximumWeight;
        suitcases = new ArrayList<>();
    }

    public void addSuitcase(Suitcase Suitcase) {
        if (totalWeight() + Suitcase.totalWeight() > maximumWeight) {
            return;
        }

        suitcases.add(Suitcase);
    }

    public int totalWeight() {
        return suitcases.stream()
                .mapToInt(suitcase -> suitcase.totalWeight())
                .reduce(0, (sum, cur) -> sum + cur);
    }

    public void printItems() {
        suitcases.forEach(System.out::println);
    }

    @Override
    public String toString() {
        if (suitcases.isEmpty()) {
            return "no suitcases (0 kg)";
        }

        if (suitcases.size() == 1) {
            return "1 suitcase (" + totalWeight() + " kg)";
        }

        return suitcases.size() + " suitcases (" + totalWeight() + " kg)";
    }
}
