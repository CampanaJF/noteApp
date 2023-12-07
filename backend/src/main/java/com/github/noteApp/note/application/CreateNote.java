package com.github.noteApp.note.application;

import com.github.noteApp.category.domain.Category;
import com.github.noteApp.category.domain.CategoryRepository;
import com.github.noteApp.note.domain.Note;
import com.github.noteApp.note.domain.NoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Service
public class CreateNote {

  private final NoteRepository noteRepository;
  private final CategoryRepository categoryRepository;

  public void execute(String title, String noteContent, List<Integer> categoriesId){

    Note newNote = new Note(getCategories(categoriesId));

    newNote.setTitle(title);
    newNote.setArchived(false);
    newNote.setCreationDate(new Date());
    newNote.setContent(noteContent);
    newNote.setLastEdit(null);

    this.noteRepository.saveNote(newNote);
  }

  private List<Category> getCategories(List<Integer> categoriesId){
    List<Category> categories = this.categoryRepository.getCategories();

    return categories.stream().filter(category -> categoriesId.contains(category.getId())).toList();

  }

}
