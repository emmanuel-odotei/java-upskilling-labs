package intermediate.week1_labs.src.oop.collections;

import java.util.Comparator;

public class ProductPriceComparator implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        return Double.compare(p1.price(), p2.price());
    }
}
