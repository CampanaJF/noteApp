import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  private content = new BehaviorSubject<string>('');
  private title = new BehaviorSubject<string>('');
  private id = new BehaviorSubject<number>(0);

  constructor() { }

  id$ = this.id.asObservable();
  content$ = this.content.asObservable();
  title$ = this.title.asObservable();

  setContent(content: string) {
    this.content.next(content);
  }

  setTitle(title: string) {
    this.title.next(title);
  }

  setId(id: number) {
    this.id.next(id);
  }

  
}
