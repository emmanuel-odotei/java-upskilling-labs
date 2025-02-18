package com.amalitech.social_media.services;

import com.amalitech.social_media.entities.UserProfile;
import com.amalitech.social_media.repositories.UserProfileRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserProfileService {
    private final UserProfileRepository userRepository;

    public UserProfileService(UserProfileRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserProfile createUserProfile(UserProfile profile) {
        return userRepository.save(profile);
    }

    public Optional<UserProfile> getUserProfile(String username) {
        return userRepository.findByUsername(username);
    }

    public UserProfile updateUserProfile(UserProfile updatedProfile) {
        return userRepository.save(updatedProfile);
    }
}
