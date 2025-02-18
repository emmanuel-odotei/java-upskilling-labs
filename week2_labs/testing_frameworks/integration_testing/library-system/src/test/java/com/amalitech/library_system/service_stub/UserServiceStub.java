package com.amalitech.library_system.service_stub;

import com.amalitech.library_system.entities.User;
import com.amalitech.library_system.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceStub implements UserService {
    public User getUserByUsername(String username) {
        if ("john_doe".equals(username)) {
                return new User(1L, "john_doe",  "john@example.com");
        }
        return null;
    }

    public User registerUser(String username, String email) {
        return new User(2L, username,  email);
    }
}
