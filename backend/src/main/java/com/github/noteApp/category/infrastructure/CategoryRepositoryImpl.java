package com.github.noteApp.category.infrastructure;

import com.github.noteApp.category.domain.Category;
import com.github.noteApp.category.domain.CategoryRepository;
import com.github.noteApp.category.infrastructure.jpa.CategoryJPARepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class CategoryRepositoryImpl implements CategoryRepository {

  private CategoryJPARepository categoryJPARepository;

  @Override
  public List<Category> getCategories() {
    return this.categoryJPARepository.findAll();
  }
}
