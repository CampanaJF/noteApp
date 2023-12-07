import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../environment/environment';
import { Observable } from 'rxjs';
import { NoteRequest } from '../models/note.request.model';

@Injectable({
  providedIn: 'root'
})
export class NoteService {
  url = environment.endpoint;
  constructor(private http: HttpClient) { }

  getAllNotes(): Observable<any> {
    return this.http.get(this.url + `/notes/listAll`);
  }

  getActiveNotes(): Observable<any> {
    return this.http.get(this.url + `/notes/listActive`);
  }

  getArchivedNotes(): Observable<any> {
    return this.http.get(this.url + `/notes/listArchived`);
  }

  createNewNote(note: NoteRequest){
    return this.http.post(this.url + `/notes/new` , note);
  }

  editNote(noteId: number, note: NoteRequest){
    return this.http.put(this.url + `/notes/edit/${noteId}` , note);
  }

  deleteNote(noteId: number){
    return this.http.put(this.url + `/notes/delete/${noteId}`, {});
  }

  archiveNote(noteId: number){
    return this.http.put(this.url + `/notes/archive/${noteId}`, {});
  }
}
