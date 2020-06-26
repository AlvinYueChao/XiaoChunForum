package org.example.alvin.repository;

import org.example.alvin.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
    void deleteByPostId(Integer postId);
}
