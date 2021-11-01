public class OneItemBox extends Box {
    private Item contents;

    public OneItemBox() {
        contents = null;
    }

    @Override
    public void add(Item item) {
        if (contents == null) {
            contents = item;
        }
    }

    @Override
    public boolean isInBox(Item item) {
        return item.equals(contents);
    }
}
