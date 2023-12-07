import { Component, OnInit } from '@angular/core';
import { Note } from 'src/app/models/note.model';
import { NoteService } from 'src/app/services/note.service';
import { CategoryService } from 'src/app/services/category.service';
import { Category } from 'src/app/models/category.model';

@Component({
  selector: 'app-active',
  templateUrl: './active.component.html',
  styleUrls: ['./active.component.css']
})
export class ActiveComponent implements OnInit{

  categories: Category[];
  notes: Note [] = [];
  filteredNotes: Note[] = [];
  selectedCategory: string | null = null;


  constructor(
    private noteService: NoteService,
    private categoryService: CategoryService
  ){

  }

  ngOnInit(): void {
    this.getActiveNotes();
    this.getCategories();
  }

  getActiveNotes() {
    this.noteService.getActiveNotes().subscribe(res => {
      if (res) {
        this.notes = res;
        this.filterNotes();
      }
    });
  }

  getCategories(){
    this.categoryService.getCategories().subscribe(res => {
      if (res) {
        this.categories = res;
      }
    });
  }

  filterNotes() {
    console.log('Selected Category:', this.selectedCategory);
    if (this.selectedCategory) {
      this.filteredNotes = this.notes.filter(note => {
        const hasMatchingCategory = note.categories.some(category => {
          return category.id.toString() === this.selectedCategory;
        });
        return hasMatchingCategory;
      });
    } else {
      this.filteredNotes = [...this.notes];
    }
  }

  onCategoryFilterChange(event: any) {
    this.selectedCategory = event.target.value;
    this.filterNotes();
  }

  onNoteDeleted(noteId: number) {
    this.notes = this.notes.filter(note => note.id !== noteId);
    this.filterNotes();
  }
}
