import { Injectable, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Book } from '../common/book';

@Injectable({
  providedIn: 'root'
})
export class BookService implements OnInit {

  private configUrl = "assets/data/config.json";

  constructor(private httpClient: HttpClient) {
    this.ngOnInit();
  }
  ngOnInit(): void {
    this.getJSON().subscribe(data => {
      localStorage.setItem("onlineBackEndBaseURL", data["onlineBackEndBaseURL"]);
    });
  }

  public getJSON(): Observable<any> {
    return this.httpClient.get(this.configUrl)
  }

  getBooks(categoryId: Number): Observable<Book[]> {
     let baseUrl = localStorage.getItem('onlineBackEndBaseURL');
     console.log('baseUrl :'+ baseUrl);
     return this.httpClient.get<BooksResponseMapping>(baseUrl + '/search/categoryid?id=' + categoryId).pipe(
      map(response => response._embedded.books)
    );
  }

}
export interface BooksResponseMapping {
  _embedded: {
    books: Book[];
  };
}
