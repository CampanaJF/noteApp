import { Component, Input, Output, EventEmitter } from '@angular/core';
import { NoteService } from '../../services/note.service';
import { Router } from '@angular/router';
import { DataService } from 'src/app/services/data.service';

@Component({
  selector: 'app-listnotes',
  templateUrl: './listnotes.component.html',
  styleUrls: ['./listnotes.component.css']
})
export class ListnotesComponent {

  constructor(
    private noteService: NoteService,
    private dataService: DataService,
    private router: Router,
  ){

  }

  @Input() id: number;
  @Input() title: string;
  @Input() content: string;
  @Input() creation: string;
  @Input() edit: string;
  @Input() archived: boolean;
  @Input() categories: any[];

  @Output() noteDeleted: EventEmitter<number> = new EventEmitter<number>();

  deleteNote(id: number) {
    this.noteService.deleteNote(id).subscribe({
        next: () => {
          this.noteDeleted.emit(id);
        }
      })
  }

  archiveNote(id: number) {
    this.noteService.archiveNote(id).subscribe({
        next: () => {
          this.noteDeleted.emit(id);
        }
      })
  }

  editNote(){
    this.dataService.setId(this.id);
    this.dataService.setContent(this.content);
    this.dataService.setTitle(this.title);
    this.router.navigateByUrl('edit');
  }
  

}
