package com.amalitech.social_media.services;

import com.amalitech.social_media.entities.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserLoginService {
    private final UserProfileService userProfileService;

    @Autowired
    public UserLoginService(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    public boolean login(String username, String password) {
        Optional<UserProfile> profile = userProfileService.getUserProfile(username);
        return profile.isPresent();
    }
}
