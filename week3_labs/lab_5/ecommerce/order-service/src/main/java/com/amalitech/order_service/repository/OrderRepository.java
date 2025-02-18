package week3_labs.lab_5.ecommerce.order;

import com.amalitech.order_service.model.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository {
    private final List<Order> orders = new ArrayList<Order>();

    public List<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public Order getOrder(int id) {
        return orders.stream().filter(item -> item.getId() == id).findFirst().orElse(null);
    }

    public List<Order> getOrdersByCustomer(int customer_id) {
        return orders.stream().filter(item -> item.getCustomerId() == customer_id).toList();
    }
}
