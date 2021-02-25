import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Book } from '../common/book';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  private baseUrl:string = environment.apiUrl;
  constructor(private httpClient: HttpClient) {}

  getBooks(categoryId: Number): Observable<Book[]> {
     console.log('Backend Base Url :'+ this.baseUrl);
     return this.httpClient.get<BooksResponseMapping>(this.baseUrl + '/search/categoryid?id=' + categoryId).pipe(
       map(response => response._embedded.books)
    );
  }

}
export interface BooksResponseMapping {
  _embedded: {
    books: Book[];
  };
}
