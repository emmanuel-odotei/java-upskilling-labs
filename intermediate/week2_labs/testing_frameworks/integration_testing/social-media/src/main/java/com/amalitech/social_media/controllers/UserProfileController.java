package com.amalitech.social_media.controllers;

import com.amalitech.social_media.entities.UserProfile;
import com.amalitech.social_media.services.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/profile")
public class UserProfileController {
    private final UserProfileService userProfileService;

    @Autowired
    public UserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @PostMapping("/create")
    public ResponseEntity<UserProfile> createUserProfile(@RequestBody UserProfile profile) {
        UserProfile createdProfile = userProfileService.createUserProfile(profile);
        return new ResponseEntity<>(createdProfile, HttpStatus.CREATED);
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserProfile> getUserProfile(@PathVariable String username) {
        Optional<UserProfile> profile = userProfileService.getUserProfile(username);
        return profile.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/update")
    public ResponseEntity<UserProfile> updateUserProfile(@RequestBody UserProfile profile) {
        UserProfile updatedProfile = userProfileService.updateUserProfile(profile);
        return new ResponseEntity<>(updatedProfile, HttpStatus.OK);
    }
}
