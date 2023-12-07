package com.github.noteApp.category.application;

import com.github.noteApp.category.domain.Category;
import com.github.noteApp.category.domain.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ListCategories {

  private final CategoryRepository categoryRepository;

  public List<Category> execute(){
    return this.categoryRepository.getCategories();
  }
}
