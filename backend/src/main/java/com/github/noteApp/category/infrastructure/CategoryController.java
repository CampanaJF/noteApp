package com.github.noteApp.category.infrastructure;

import com.github.noteApp.category.application.ListCategories;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/categories")
@AllArgsConstructor
public class CategoryController {

  private final ListCategories listCategories;

  @GetMapping("/all")
  public ResponseEntity listCategories(){
    var categories = listCategories.execute();
    return ok(categories);
  }
}
