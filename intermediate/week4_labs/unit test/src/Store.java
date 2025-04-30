package Week

import java.util.ArrayList;
import java.util.List;

public class Store {
    private final List<Product> productList;

    public Store() {
        this.productList = new ArrayList<>();
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void displayProducts() {
        if (productList.isEmpty()) {
            System.out.println("No products available in the store.");
        } else {
            System.out.println("Available Products:");
            for ( Product product : productList) {
                System.out.println(product);
            }
        }
    }

    public Product findProductById(int id) {
        for ( Product product : productList) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}
