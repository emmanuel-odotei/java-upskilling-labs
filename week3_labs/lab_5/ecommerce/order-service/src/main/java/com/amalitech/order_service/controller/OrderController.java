package week3_labs.lab_5.ecommerce.order;

import com.amalitech.order_service.model.Order;
import com.amalitech.order_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderRepository orderRepository;

    @GetMapping
    public List<Order> getAllOrders() {
        return this.orderRepository.getOrders();
    }
    @PostMapping
    public void createOrder(@RequestBody Order order) {
        this.orderRepository.addOrder(order);
    }
    @GetMapping("/customer/{customerId}")
    public List<Order> getOrdersByCustomerId(@PathVariable int customerId) {
        return this.orderRepository.getOrdersByCustomer(customerId);
    }
}
