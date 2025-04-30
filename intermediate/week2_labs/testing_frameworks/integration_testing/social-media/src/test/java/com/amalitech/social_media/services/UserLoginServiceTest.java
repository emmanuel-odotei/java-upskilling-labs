package com.amalitech.social_media.services;

import com.amalitech.social_media.entities.UserProfile;
import com.amalitech.social_media.repositories.UserProfileRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserLoginServiceTest {
    @Mock
    private UserProfileService userProfileService;

    @InjectMocks
    private UserLoginService userLoginService;


    @Test
    public void testLoginSuccess() {
        UserProfile profile = new UserProfile(1L, "John", "Doe", "john@example.com", "profilePic.jpg", "password123");
        when(userProfileService.getUserProfile("john_doe")).thenReturn(Optional.of(profile));
        boolean loginResult = userLoginService.login("john_doe", "password123");
        assertTrue(loginResult);
    }

    @Test
    public void testLoginFailure() {
       when(userProfileService.getUserProfile("john_doe")).thenReturn(Optional.empty());
        boolean loginResult = userLoginService.login("john_doe", "wrong_password");
        assertFalse(loginResult);
    }
}