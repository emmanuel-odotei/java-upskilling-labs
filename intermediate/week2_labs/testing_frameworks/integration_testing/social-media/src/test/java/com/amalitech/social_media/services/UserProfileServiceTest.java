package com.amalitech.social_media.services;

import com.amalitech.social_media.entities.UserProfile;
import com.amalitech.social_media.repositories.UserProfileRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserProfileServiceTest {
    @InjectMocks
    private UserProfileService userProfileService;
    @Mock
    private UserProfileRepository userRepository;



    @Test
    public void testCreateUserProfile() {
        UserProfile profile = new UserProfile(1L, "john_doe", "John", "Doe", "john@example.com", "profilePic.jpg");

        when(userRepository.save(profile)).thenReturn(profile);

        UserProfile createdProfile = userProfileService.createUserProfile(profile);

        assertNotNull(createdProfile);
        assertEquals("john_doe", createdProfile.getUsername());
        assertEquals("john@example.com", createdProfile.getEmail());
    }

    @Test
    public void testGetUserProfile() {
        String username = "john_doe";
        UserProfile profile = new UserProfile(1L, username, "John", "Doe", "john@example.com", "profilePic.jpg");

        when(userRepository.findByUsername(username)).thenReturn(Optional.of(profile));

        Optional<UserProfile> foundProfile = userProfileService.getUserProfile(username);

        assertTrue(foundProfile.isPresent());
        assertEquals("john_doe", foundProfile.get().getUsername());
    }
}