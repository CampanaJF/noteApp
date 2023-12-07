package com.github.noteApp.note.Infrastructure;

import com.github.noteApp.note.domain.Note;
import com.github.noteApp.note.Infrastructure.jpa.NoteJPARepository;
import com.github.noteApp.note.domain.NoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class NoteRepositoryImpl implements NoteRepository {

  private final NoteJPARepository noteJPARepository;

  @Override
  public void saveNote(Note note) {
    noteJPARepository.save(note);
  }

  @Override
  public Note getNote(Integer noteId) {
    return noteJPARepository.findById(noteId).orElse(null);
  }

  @Override
  public List<Note> getAll() {
    return noteJPARepository.findAllByOrderByCreationDateAsc();
  }

  @Override
  public List<Note> getAllActiveNotes() {

    return noteJPARepository.findAllByArchivedOrderByCreationDateAsc(false);
  }

  @Override
  public List<Note> getAllArchivedNotes() {

    return noteJPARepository.findAllByArchivedOrderByCreationDateAsc(true);
  }

  @Override
  public void deleteNote(Note note) {
    noteJPARepository.delete(note);
  }


}
