import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../environment/environment';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  url = environment.endpoint;
  constructor(private http: HttpClient) { }

  getCategories(): Observable<any> {
    return this.http.get(this.url + `/categories/all`);
  }

}
