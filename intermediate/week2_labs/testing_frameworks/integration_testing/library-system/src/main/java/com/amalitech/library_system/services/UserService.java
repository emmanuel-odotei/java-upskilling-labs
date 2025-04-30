package com.amalitech.library_system.services;

import com.amalitech.library_system.entities.User;

public interface UserService {
    public User getUserByUsername(String username);
    public User registerUser(String username, String email);
}
