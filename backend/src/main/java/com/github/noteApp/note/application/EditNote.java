package com.github.noteApp.note.application;

import com.github.noteApp.category.domain.Category;
import com.github.noteApp.category.domain.CategoryRepository;
import com.github.noteApp.note.domain.Note;
import com.github.noteApp.note.domain.NoteRepository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class EditNote {

  private final NoteRepository noteRepository;
  private final CategoryRepository categoryRepository;

  public void execute(Integer noteId,String editedTitle, String editedContent,
                      List<Integer> categoriesId){
    Note noteToEdit = getNote(noteId);

    getCategories(categoriesId);

    if(!noteToEdit.getArchived()){
      noteToEdit.setTitle(editedTitle);
      noteToEdit.setContent(editedContent);
      noteToEdit.setLastEdit(new Date());
      noteToEdit.setCategories(getCategories(categoriesId));

      saveNote(noteToEdit);
    }

  }

  private Set<Category> getCategories(List<Integer> categoriesId){
    List<Category> allCategories = this.categoryRepository.getCategories();

    List<Category> noteCategories = allCategories.stream()
            .filter(category -> categoriesId.contains(category.getId())).toList();

    return new HashSet<>(noteCategories);

  }

  private void saveNote(Note note){
    this.noteRepository.saveNote(note);
  }

  private Note getNote(Integer noteId){
    return this.noteRepository.getNote(noteId);
  }
}
