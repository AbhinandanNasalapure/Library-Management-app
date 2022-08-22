import { BookService } from './../../book-service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-view-books',
  templateUrl: './view-books.component.html',
  styleUrls: ['./view-books.component.css']
})
export class ViewBooksComponent implements OnInit {


  books : any;

  constructor(private bookService: BookService) { }

  ngOnInit(): void {
    this.viewAllBooks();
  }

  viewAllBooks(): void {
    this.bookService.getBooks()
    .subscribe(
      books => {
        this.books = books;
        console.log(books);
      },
      error => {
        console.log(error);
      }
    );
  }


}
