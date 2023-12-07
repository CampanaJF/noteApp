package com.github.noteApp.note.domain;

import java.util.List;

public interface NoteRepository {

  void saveNote(Note note);

  Note getNote(Integer noteId);

  List<Note> getAll();

  List<Note> getAllActiveNotes();

  List<Note> getAllArchivedNotes();

  void deleteNote(Note note);
}
