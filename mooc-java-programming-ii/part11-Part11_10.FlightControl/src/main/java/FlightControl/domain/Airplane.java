package FlightControl.domain;

public class Airplane {
    private String identifier;
    private int capacity;

    public Airplane(String identifier, int capacity) {
        this.identifier = identifier;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return identifier + " (" + capacity + " capacity)";
    }
}
