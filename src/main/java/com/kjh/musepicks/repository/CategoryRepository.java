package com.kjh.musepicks.repository;

import com.kjh.musepicks.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
