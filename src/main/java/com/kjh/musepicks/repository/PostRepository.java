package com.kjh.musepicks.repository;

import com.kjh.musepicks.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
