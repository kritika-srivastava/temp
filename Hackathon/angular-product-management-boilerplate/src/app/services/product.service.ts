import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Products } from '../products';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http: HttpClient) { }

  addProduct(product: Products): Observable<Products> {
    return this.http.post<Products>(environment.producturl, product)
      .pipe(catchError(this.handleError));
  }

  getProducts(): Observable<Products[]> {

    return this.http.get<Products[]>(environment.producturl).pipe(catchError((error) => {
      return throwError(() => {
        new Error("Please try after some time" + error.message)
      })
    }));

  }

  deleteProduct(id: number) {
    return this.http.delete(environment.producturl + `/${id}`)
      .pipe(catchError(this.handleError));
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
