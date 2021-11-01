import java.util.Objects;

public class Item {
    private String product;
    private int quantity;
    private int unitPrice;

    public Item(String product, int qty, int unitPrice) {
        this.product = product;
        quantity = qty;
        this.unitPrice = unitPrice;
    }

    public int price() {
        return unitPrice * quantity;
    }

    public void increaseQuantity() {
        quantity++;
    }

    @Override
    public String toString() {
        return product + ": " + quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return unitPrice == item.unitPrice && Objects.equals(product, item.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, unitPrice);
    }
}
