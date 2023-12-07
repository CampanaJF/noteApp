package com.github.noteApp.note.Infrastructure.dto;

import com.github.noteApp.category.domain.Category;

import java.util.List;

public record NoteDto (
        String title,
        String noteContent,
        List<Integer> categories ){
}
