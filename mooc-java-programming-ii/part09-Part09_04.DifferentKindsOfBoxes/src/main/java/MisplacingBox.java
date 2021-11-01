public class MisplacingBox extends Box {
    public MisplacingBox() {}

    @Override
    public void add(Item item) {
        return;
    }

    @Override
    public boolean isInBox(Item item) {
        return false;
    }
}
