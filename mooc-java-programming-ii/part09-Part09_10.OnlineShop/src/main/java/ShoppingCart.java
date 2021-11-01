import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Item> contents;

    public ShoppingCart() {
        contents = new ArrayList<>();
    }

    public void add(String product, int price) {
        Item item = new Item(product, 1, price);
        for (Item existingItem : contents) {
            if (item.equals(existingItem)) {
                existingItem.increaseQuantity();
                return;
            }
        }
        contents.add(item);
    }

    public int price() {
        int price = 0;
        for (Item item : contents) {
            price += item.price();
        }
        return price;
    }

    public void print() {
        for (Item item : contents) {
            System.out.println(item);
        }
    }
}
