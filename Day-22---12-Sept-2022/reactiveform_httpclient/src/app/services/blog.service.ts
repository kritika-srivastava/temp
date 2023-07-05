import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BlogService {

  constructor(private http: HttpClient) { }
  // Implement addBlog method using HttpClient for a saving a Blog details
  addBlog(blog): Observable<any> {
    let result: any;
    let options = { headers: new HttpHeaders().set('Content-Type', 'application/json') };
    result = this.http.post('http://localhost:3000/blog', blog, options);
    return result;
  }

}
