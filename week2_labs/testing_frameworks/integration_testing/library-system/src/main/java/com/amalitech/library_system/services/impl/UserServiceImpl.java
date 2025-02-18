package com.amalitech.library_system.services.impl;

import com.amalitech.library_system.entities.User;
import com.amalitech.library_system.repositories.UserRepository;
import com.amalitech.library_system.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

    public User registerUser(String username, String email) {
        return this.userRepository.save(new User(2L, username, email));
    }
}
