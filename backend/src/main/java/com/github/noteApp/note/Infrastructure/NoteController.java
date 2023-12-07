package com.github.noteApp.note.Infrastructure;

import com.github.noteApp.note.Infrastructure.dto.NoteDto;
import com.github.noteApp.note.application.*;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/notes")
@AllArgsConstructor
public class NoteController {

  private final CreateNote createNote;
  private final DeleteNote deleteNote;
  private final EditNote editNote;
  private final ListActiveNotes listActiveNotes;
  private final ListArchivedNotes listArchivedNotes;
  private final ArchiveNote archiveNote;
  private final ListAllNotes listAllNotes;

  @PostMapping("/new")
  public ResponseEntity newNote(@RequestBody NoteDto dto){
      createNote.execute(dto.title() ,dto.noteContent(), dto.categories());
      return ok().build();
  }

  @PutMapping("/edit/{noteId}")
  public ResponseEntity editNote(
          @PathVariable("noteId") Integer noteId,
          @RequestBody NoteDto dto){
    editNote.execute(noteId, dto.title(), dto.noteContent(), dto.categories());
    return ok().build();
  }

  @PutMapping("/delete/{noteId}")
  public ResponseEntity deleteNote(@PathVariable("noteId") Integer noteId){
    deleteNote.execute(noteId);
    return ok().build();
  }

  @PutMapping("/archive/{noteId}")
  public ResponseEntity archiveNote(@PathVariable("noteId") Integer noteId){
    archiveNote.execute(noteId);
    return ok().build();
  }

  @GetMapping("/listActive")
  public ResponseEntity listActive(){
    var activeNotes = listActiveNotes.execute();
    return ok(activeNotes);
  }

  @GetMapping("/listArchived")
  public ResponseEntity listArchived(){
    var archivedNotes = listArchivedNotes.execute();
    return ok(archivedNotes);
  }

  @GetMapping("/listAll")
  public ResponseEntity listAll(){
    var allNotes = listAllNotes.execute();
    return ok(allNotes);
  }
}
