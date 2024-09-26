package com.kjh.musepicks.repository;

import com.kjh.musepicks.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
//    @Query("SELECT p FROM Post p JOIN FETCH p.postCategories")
    @Query("SELECT p FROM Post p LEFT JOIN FETCH p.postCategories")
    List<Post> findAllPostsWithCategory();

}
