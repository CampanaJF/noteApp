package com.github.noteApp.note.application;

import com.github.noteApp.note.domain.Note;
import com.github.noteApp.note.domain.NoteRepository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DeleteNote {

  private final NoteRepository noteRepository;

  public void execute(Integer noteId){
    Note noteToDelete = getNote(noteId);

    if(!noteToDelete.getArchived()){
      deleteNote(noteToDelete);
    }

  }

  private void deleteNote(Note note){
    this.noteRepository.deleteNote(note);
  }

  private Note getNote(Integer noteId){
    return this.noteRepository.getNote(noteId);
  }
}
