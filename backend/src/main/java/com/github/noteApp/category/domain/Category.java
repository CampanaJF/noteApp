package com.github.noteApp.category.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.noteApp.note.domain.Note;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "categories")
public class Category {

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Integer id;

  @Enumerated(EnumType.STRING)
  private CategoryTypes category;

  @ManyToMany(mappedBy = "categories")
  @JsonIgnore
  private Set<Note> notes;

}
