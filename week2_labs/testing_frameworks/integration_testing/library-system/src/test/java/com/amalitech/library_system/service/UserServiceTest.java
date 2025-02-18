package com.amalitech.library_system.service;

import com.amalitech.library_system.entities.User;
import com.amalitech.library_system.service_stub.UserServiceStub;
import com.amalitech.library_system.services.UserService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {
    private final UserService userService = new UserServiceStub();

    @Test
    public void testGetUserByUserNameReturnsUser() {
        User user = userService.getUserByUsername("john_doe");
        assertNotNull(user);
        assertEquals("john_doe", user.getUsername());
    }

    @Test
    public void testGetUserByUserNameReturnsNullIfUserDoesNotExist() {
        User user = userService.getUserByUsername("who");
        assertNull(user);
    }

    @Test
    public void testRegisterUser() {
        User user = userService.registerUser("user", "test@example.come");
        assertNotNull(user);
        assertEquals("test@example.come", user.getEmail());
    }
}
