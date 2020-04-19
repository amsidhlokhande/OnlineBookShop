import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Book } from '../common/book';

@Injectable({
  providedIn: 'root'
})
export class BookService {

 private baseUrl="http://localhost:8080/api/v1/books";
  constructor(private httpClient:HttpClient) { }
  getBooks(categoryId: Number):Observable<Book[]>{

    return this.httpClient.get<BooksResponseMapping>(this.baseUrl + '/search/categoryid?id=' + categoryId).pipe(
      map(response => response._embedded.books)
    );
  }

}
export interface BooksResponseMapping{
  _embedded: {
    books: Book[];
  };
}
