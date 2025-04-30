package com.amalitech.social_media.controllers;

import com.amalitech.social_media.entities.Post;
import com.amalitech.social_media.services.NewsFeedService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.when;

@WebMvcTest(controllers = NewsFeedController.class)
class NewsFeedControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NewsFeedService newsFeedService;

    @Test
    public void testGetUserNewsFeed() throws Exception {
        List<Post> mockPosts = List.of(
                new Post(1L, "john_doe", "First post", LocalDateTime.now()),
                new Post(2L, "john_doe", "Second post", LocalDateTime.now())
        );

        when(newsFeedService.getUserNewsFeed("john_doe")).thenReturn(mockPosts);

        mockMvc.perform(MockMvcRequestBuilders.get("/news-feed/john_doe"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].content").value("First post"));
    }
}