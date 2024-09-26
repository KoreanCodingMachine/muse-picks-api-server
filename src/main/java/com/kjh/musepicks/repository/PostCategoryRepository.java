package com.kjh.musepicks.repository;

import com.kjh.musepicks.domain.PostCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostCategoryRepository extends JpaRepository<PostCategory, Long> {
}
