package com.github.noteApp.note.Infrastructure.jpa;

import com.github.noteApp.note.domain.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteJPARepository extends JpaRepository<Note, Integer> {
  List<Note> findAllByArchivedOrderByCreationDateAsc(boolean isArchived);
  List<Note> findAllByOrderByCreationDateAsc();
}
