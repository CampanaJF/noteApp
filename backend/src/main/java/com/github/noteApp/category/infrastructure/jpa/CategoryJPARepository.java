package com.github.noteApp.category.infrastructure.jpa;

import com.github.noteApp.category.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryJPARepository extends JpaRepository<Category, Integer> {
}
