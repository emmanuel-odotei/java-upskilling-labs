package week3_labs.lab_4.ecommerce.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {
    private int id;
    private int customerId;
    private int productId;
    private int quantity;
}
