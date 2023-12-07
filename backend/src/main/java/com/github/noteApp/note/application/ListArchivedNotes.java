package com.github.noteApp.note.application;

import com.github.noteApp.note.domain.Note;
import com.github.noteApp.note.domain.NoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ListArchivedNotes {

  private final NoteRepository noteRepository;

  public List<Note> execute(){
    return this.noteRepository.getAllArchivedNotes();
  }
}
