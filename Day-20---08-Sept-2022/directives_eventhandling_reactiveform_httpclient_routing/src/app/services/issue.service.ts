import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Issue } from '../models/Issue';

@Injectable({
  providedIn: 'root'
})

export class IssueService {

  constructor(private http: HttpClient) { }


  // Implement addIssue method using HttpClient for a saving a Issue details
  addIssue(issue): Observable<any> {
    
    let options = { headers: new HttpHeaders().set('Content-Type', 'application/json') };
    let result: any;
    result = this.http.post('http://localhost:3000/issues', issue, options);
    return result;
  }

  getIssues(): Observable<any> {
    let result: any;
    result = this.http.get<Issue[]>('http://localhost:3000/issues');
    return result;
  }

  // Implement deleteIssue method to delete a issue by id
  deleteIssue(id: any): Observable<any> {
    let result: any;
    result = this.http.delete(`http://localhost:3000/issues/${id}/`)
    return result;
  }
}
