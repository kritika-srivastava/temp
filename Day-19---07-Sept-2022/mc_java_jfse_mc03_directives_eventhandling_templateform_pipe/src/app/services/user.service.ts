import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Contact } from '../models/Contact';
@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  // Implement addContacts method using HttpClient for a saving a Contacts details
  addContact(contact): Observable<any> {
    let result: any;
    result = this.http.post('http://localhost:3000/contacts', contact);
    return result;
  }

  // Implement getAllContactss method using HttpClient for getting all Contacts details
  getAllContacts(): Observable<any> {
    let result: any;
    result = this.http.get<Contact[]>('http://localhost:3000/contacts');
    return result;
  }
}
