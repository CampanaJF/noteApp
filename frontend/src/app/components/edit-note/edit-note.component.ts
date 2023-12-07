import { Component } from '@angular/core';
import { Category } from 'src/app/models/category.model';
import { FormArray, FormBuilder, FormGroup, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { NoteService } from 'src/app/services/note.service';
import { CategoryService } from 'src/app/services/category.service';
import { DataService } from 'src/app/services/data.service';

@Component({
  selector: 'app-edit-note',
  templateUrl: './edit-note.component.html',
  styleUrls: ['./edit-note.component.css']
})
export class EditNoteComponent {

  editNoteForm: FormGroup;
  content: string;
  title: string;
  id: number;
  categories: Category[];

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private noteService: NoteService,
    private categoryService: CategoryService,
    private dataService: DataService,
  ) {
    this.editNoteForm = this.fb.group({
      title: [''],
      noteContent: [''],
      categories: this.fb.array([])
    });
  }

  ngOnInit(): void {
    this.getCategories();
    this.dataService.id$.subscribe((id) => (this.id = id));
    this.dataService.content$.subscribe((content) => (this.content = content));
    this.dataService.title$.subscribe((title) => (this.title = title));

    this.dataService.title$.subscribe((title) => this.editNoteForm.get('title')?.patchValue(title));
    this.dataService.content$.subscribe((content) => this.editNoteForm.get('noteContent')?.patchValue(content));
  }

  getCategories() {
    this.categoryService.getCategories().subscribe(res => {
      if (res) {
        this.categories = res;
      }
    });
  }

  onSubmit() {
    const fields = this.editNoteForm.value;

      this.noteService.editNote(this.id,this.editNoteForm.value).subscribe({
        next: () => {
          this.router.navigateByUrl('/home');
        }
      }) 
  }

  onCheckboxChange(e: Event) {
    const includedCategories: FormArray = this.editNoteForm.get('categories') as FormArray;
    const categoryCheckbox = (<HTMLInputElement>e.target).value
    if ((<HTMLInputElement>e.target).checked) {
      includedCategories.push(new FormControl(categoryCheckbox));
    } else {
      let i: number = 0;
      includedCategories.controls.forEach((item: any) => {
        if (item.value == categoryCheckbox) {
          includedCategories.removeAt(i);
          return;
        }
        i++;
      });
    }
  }

}
