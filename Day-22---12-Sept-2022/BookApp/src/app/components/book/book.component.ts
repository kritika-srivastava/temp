import { Component, OnInit } from '@angular/core';
import { Book } from 'src/app/model/book';
import { BookService } from 'src/app/services/book.service';
import { RoutingService } from 'src/app/services/routing.service';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit {


  book: Book = new Book();
  books: Book[] = []
  errormessage = '';


  addbook() {
    this.bookService.addbook(this.book).subscribe(res => {
      alert('Book Added');
      this.books.push(res);
      this.book = new Book;
    }, error => this.errormessage = error);


  }
  constructor(private bookService: BookService, private routingService: RoutingService) { }


  getbooks() {
    this.bookService.fetchbooks().subscribe(res => this.books = res, err => this.errormessage = err);
  }
  ngOnInit(): void {
  }

}
