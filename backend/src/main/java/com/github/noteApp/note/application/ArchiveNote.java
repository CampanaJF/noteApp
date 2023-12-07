package com.github.noteApp.note.application;

import com.github.noteApp.note.domain.Note;
import com.github.noteApp.note.domain.NoteRepository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ArchiveNote {

  private final NoteRepository noteRepository;

  public void execute(Integer noteId){

    Note foundNote = getNote(noteId);

    foundNote.setArchived(!foundNote.getArchived());
    saveNote(foundNote);

  }

  private Note getNote(Integer noteId){
    return this.noteRepository.getNote(noteId);
  }

  private void saveNote(Note note){
    this.noteRepository.saveNote(note);
  }
}
