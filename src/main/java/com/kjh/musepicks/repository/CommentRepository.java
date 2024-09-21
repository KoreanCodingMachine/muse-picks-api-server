package com.kjh.musepicks.repository;

import com.kjh.musepicks.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
