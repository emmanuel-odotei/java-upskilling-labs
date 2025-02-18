package com.amalitech.social_media.repositories;

import com.amalitech.social_media.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByUsernameOrderByCreatedAtDesc(String username);
}
