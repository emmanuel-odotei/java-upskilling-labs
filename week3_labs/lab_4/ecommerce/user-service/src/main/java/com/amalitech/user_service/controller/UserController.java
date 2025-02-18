package week3_labs.lab_4.ecommerce.user;

import com.amalitech.user_service.model.Order;
import com.amalitech.user_service.model.User;
import com.amalitech.user_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;
    private final DiscoveryClient discoveryClient;
    private final RestClient restClient;

    public UserController(UserRepository userRepository, DiscoveryClient discoveryClient, RestClient.Builder restClientBuilder) {
        this.userRepository = userRepository;
        this.discoveryClient = discoveryClient;
        restClient = restClientBuilder.build();
    }

    @PostMapping
    public void createUser(@RequestBody User user) {
        userRepository.addUser(user);
    }
    @GetMapping
    public List<User> getUsers() {
        return userRepository.getUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) {
        return userRepository.getUser(id);
    }
    @GetMapping("/{id}/orders")
    public List<Order> getUserOrders(@PathVariable int id) {

        ServiceInstance instance = discoveryClient.getInstances("order-service").get(0);
        System.out.println(instance.getUri());
        return restClient.get().uri(instance.getUri() + "/orders/customer/"+id).retrieve().body(new ParameterizedTypeReference<List<Order>>() {
        });
    }
}
