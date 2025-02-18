package week3_labs.lab_4.ecommerce.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
    private int id;
    private String productName;
    private String description;
    private double price;
}
