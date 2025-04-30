package com.amalitech.social_media.controllers;

import com.amalitech.social_media.entities.UserProfile;
import com.amalitech.social_media.services.UserProfileService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@WebMvcTest(controllers = UserProfileController.class)
class UserProfileControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserProfileService userProfileService;

    @Test
    public void testCreateUserProfile() throws Exception {
        UserProfile profile = new UserProfile(null, "john_doe", "John", "Doe", "john@example.com", "profilePic.jpg");
        ObjectMapper objectMapper = new ObjectMapper();
        String content = objectMapper.writeValueAsString(profile);
        when(userProfileService.createUserProfile(any(UserProfile.class))).thenReturn(profile);

        mockMvc.perform(MockMvcRequestBuilders.post("/profile/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("john_doe"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("john@example.com"));
    }

    @Test
    public void testGetUserProfile() throws Exception {
        UserProfile profile = new UserProfile(null, "john_doe", "John", "Doe", "john@example.com", "profilePic.jpg");
        when(userProfileService.getUserProfile("john_doe")).thenReturn(Optional.of(profile));
        mockMvc.perform(MockMvcRequestBuilders.get("/profile/john_doe"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("john_doe"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("john@example.com"));
    }
}