package week3_labs.lab_5.ecommerce.product;

import com.amalitech.product_service.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> products = new ArrayList<Product>();
    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public Product getProduct(int id) {
        return products.get(id);
    }
}
