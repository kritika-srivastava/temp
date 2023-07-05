import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { catchError, Observable, throwError } from 'rxjs';
import { environment } from 'src/environments/environment';
import { User } from '../model/user';
@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  adduser(user: User): Observable<User> {
    return this.http.post<User>(environment.userurl, user)
      .pipe(catchError((error) => this.handleError(error)));
  }

  fetchusers(): Observable<User[]> {
    return this.http.get<User[]>(environment.userurl)
      .pipe(catchError((error) => this.handleError(error)));
  }

  fetchuserById(id: any): Observable<User> {
    return this.http.get<User>(environment.userurl + `/${id}`)
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
