import { Component, OnInit } from '@angular/core';
import { Book } from 'src/app/common/book';
import { BookService } from 'src/app/services/book.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-book-list',
  //templateUrl: './book-list.component.html',
  templateUrl: './book-grid.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit {

  books:Book[]= null;
  currentCategoryId:Number;
  constructor(private bookService:BookService, private activatedRoute:ActivatedRoute) { }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(params=>{
      this.bookList();
    })

  }
  bookList(){
  const hasCategoryId:Boolean = this.activatedRoute.snapshot.paramMap.has("id")

  if(hasCategoryId){
      this.currentCategoryId = +this.activatedRoute.snapshot.paramMap.get("id");
  }else{
    //Set Default currentCategoryId
    this.currentCategoryId = 1;
  }

    this.bookService.getBooks(this.currentCategoryId).subscribe(responseData => {
      this.books = responseData;
      console.log(responseData);
    });
  }

}
