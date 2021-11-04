public class Hideout<T> {
    private T hiding;

    public Hideout() {
        hiding = null;
    }

    public void putIntoHideout(T toHide) {
        hiding = toHide;
    }

    public T takeFromHideout() {
        T wasHiding = hiding;
        hiding = null;
        return wasHiding;
    }

    public boolean isInHideout() {
        return hiding != null;
    }
}
