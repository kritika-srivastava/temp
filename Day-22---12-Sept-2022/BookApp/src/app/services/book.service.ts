import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { catchError, Observable, throwError } from 'rxjs';
import { Book } from '../model/book';
import { environment } from 'src/environments/environment';
@Injectable({
  providedIn: 'root'
})
export class BookService {

  constructor(private http: HttpClient) { }

  addbook(book: Book): Observable<Book> {
    return this.http.post<Book>(environment.bookurl, book)
      .pipe(catchError((error) => this.handleError(error)));
  }

  fetchbooks(): Observable<Book[]> {
    return this.http.get<Book[]>(environment.bookurl)
      .pipe(catchError((error) => this.handleError(error)));
  }

  private handleError(error: HttpErrorResponse) {
    if (error.status === 0) {
      console.log("Error occured, please try after some time.");
    }
    else {
      console.log("Error occured");
    }

    return throwError(() => { `${error.message}` });
  }
}
