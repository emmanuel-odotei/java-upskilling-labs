package week3_labs.lab_5.ecommerce.product;

import com.amalitech.product_service.Repository.ProductRepository;
import com.amalitech.product_service.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductRepository productRepository;

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.getProducts();
    }

    @PostMapping
    public void addProduct(@RequestBody Product product) {
        productRepository.addProduct(product);
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable int id) {
        return productRepository.getProduct(id);
    }
}
