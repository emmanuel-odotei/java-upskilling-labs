package com.amalitech.social_media.services;

import com.amalitech.social_media.entities.Post;
import com.amalitech.social_media.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsFeedService {
    private final PostRepository postRepository;

    @Autowired
    public NewsFeedService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getUserNewsFeed(String username) {
        return postRepository.findByUsernameOrderByCreatedAtDesc(username);
    }
}
