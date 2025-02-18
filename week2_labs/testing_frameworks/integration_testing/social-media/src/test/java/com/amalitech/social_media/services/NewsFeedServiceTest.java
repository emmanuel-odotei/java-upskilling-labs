package com.amalitech.social_media.services;

import com.amalitech.social_media.entities.Post;
import com.amalitech.social_media.repositories.PostRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class NewsFeedServiceTest {
    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private NewsFeedService newsFeedService;

    @Test
    public void testGetUserNewsFeed() {
        String username = "john_doe";
        List<Post> mockPosts = List.of(
                new Post(1L, username, "First post", LocalDateTime.now()),
                new Post(2L, username, "Second post", LocalDateTime.now())
        );
        when(postRepository.findByUsernameOrderByCreatedAtDesc(username)).thenReturn(mockPosts);
        List<Post> newsFeed = newsFeedService.getUserNewsFeed(username);
        assertEquals(2, newsFeed.size());
        assertEquals("First post", newsFeed.get(0).getContent());
    }
}