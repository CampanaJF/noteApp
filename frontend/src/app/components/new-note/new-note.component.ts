import { Component, Input  } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { Category } from 'src/app/models/category.model';
import { NoteService } from 'src/app/services/note.service';
import { CategoryService } from 'src/app/services/category.service';


@Component({
  selector: 'app-new-note',
  templateUrl: './new-note.component.html',
  styleUrls: ['./new-note.component.css']
})
export class NewNoteComponent {

  newNoteForm: FormGroup;
  categories: Category[];
  // @Input() content: string;

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private noteService: NoteService,
    private categoryService: CategoryService
  ) {
    this.newNoteForm = this.fb.group({
      title: [''],
      noteContent: [''],
      categories: this.fb.array([])
    });
  
  }

  ngOnInit(): void {
    this.getCategories();
  }

  getCategories() {
    this.categoryService.getCategories().subscribe(res => {
      if (res) {
        this.categories = res;
      }
    });
  }

  onSubmit() {
    const fields = this.newNoteForm.value;

      this.noteService.createNewNote(this.newNoteForm.value).subscribe({
        next: () => {
          this.router.navigateByUrl('/home');
        }
      }) 
  }

  onCheckboxChange(e: Event) {
    const includedCategories: FormArray = this.newNoteForm.get('categories') as FormArray;
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
