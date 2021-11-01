import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Warehouse {
    private Map<String, Integer> productPrice;
    private Map<String, Integer> productStock;

    public Warehouse() {
        productPrice = new HashMap<>();
        productStock = new HashMap<>();
    }

    public void addProduct(String product, int price, int stock) {
        productPrice.put(product, price);
        productStock.put(product, stock);
    }

    public int price(String product) {
        if (productPrice.get(product) == null) {
            return -99;
        }
        return productPrice.get(product);
    }

    public int stock(String product) {
        if (productStock.get(product) == null) {
            return 0;
        }
        return productStock.get(product);
    }

    public boolean take(String product) {
        if (productStock.get(product) == null) {
            return false;
        }
        int stock = productStock.get(product);
        if (stock == 0) {
            return false;
        }
        productStock.put(product, stock - 1);
        return true;
    }

    public Set<String> products() {
        return productStock.keySet();
    }
}
