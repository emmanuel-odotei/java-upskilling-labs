package com.amalitech.social_media.controllers;

import com.amalitech.social_media.entities.Post;
import com.amalitech.social_media.services.NewsFeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RequestMapping("/news-feed")
@RestController
public class NewsFeedController {

    private final NewsFeedService newsFeedService;

    @Autowired
    public NewsFeedController(NewsFeedService newsFeedService) {
        this.newsFeedService = newsFeedService;
    }

    @GetMapping("/{username}")
    public ResponseEntity<List<Post>> getUserNewsFeed(@PathVariable String username) {
        List<Post> newsFeed = newsFeedService.getUserNewsFeed(username);
        return new ResponseEntity<>(newsFeed, HttpStatus.OK);
    }
}
