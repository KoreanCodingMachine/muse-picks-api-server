package com.kjh.musepicks.repository;

import com.kjh.musepicks.domain.Account;
import com.kjh.musepicks.domain.Comment;
import com.kjh.musepicks.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query("select c from Comment c join fetch c.posts")
    List<Comment> findAllCommentsWithPost();

    @Query("select c from Comment c join fetch c.account")
    List<Comment> findAllCommentsWithAccount();

    @Query("select c from Comment c join fetch c.account where c.account.id = :userId")
    List<Comment> findByUserId(@Param("userId") Long userId);
}
