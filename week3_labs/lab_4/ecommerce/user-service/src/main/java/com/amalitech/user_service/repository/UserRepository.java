package week3_labs.lab_4.ecommerce.user;

import com.amalitech.user_service.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }
    public List<User> getUsers() {
        return users;
    }
    public User getUser(int id) {
        return users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
    }
}
