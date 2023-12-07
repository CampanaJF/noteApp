package com.github.noteApp.note.domain;

import com.github.noteApp.category.domain.Category;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "notes")
public class Note {

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Integer id;

  private String title;

  private String content;

  private Date creationDate;

  private Date lastEdit;

  private Boolean archived;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
          name = "note_categories",
          joinColumns = @JoinColumn(name = "note_id"),
          inverseJoinColumns = @JoinColumn(name = "category_id")
  )
  private Set<Category> categories;

  public Note(List<Category> categories) {
    this.categories = new HashSet<>(categories);
  }

  public void addCategories(List<Category> categories){
    this.categories.addAll(categories);
  }


}
