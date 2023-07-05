import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';
import { Contact } from '../models/Contact';
import { from } from 'rxjs';
import { IncompleteTagOpenToken } from '@angular/compiler/src/ml_parser/tokens';
@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {
  // form contains the name of the Contact and mobile number
  form: any = {};
  // contacts is to store all Contacts data
  contacts: Contact[] = [];
  // message is to display message
  message;

  // isContactedAdded is for validating contact is added or not
  isContactedAdded?: boolean;

  searchText = '';
  constructor(private userservice: UserService) { }
  // Call UserService and use getAllContacts method to get Contacts data
  ngOnInit() {
    this.userservice.getAllContacts().subscribe(
      data => {
        this.contacts = data;
      });
  }
  display() {
    this.userservice.getAllContacts().subscribe(
      data => {
        this.contacts = data;
      });
  }
  // Write logic to add a Contact by using addContact method of UserService
  // Display message 'Contact already exists' if already a contact exists with same mobile number
  // Display message 'Failed to add Contact' while error handling
  // Display message 'Contact Added' if contact is added
  onSubmit() {
    if (this.form != undefined) {
      if (this.form.name != undefined
        && this.form.mobile != undefined
        && this.form.name !== " "
        && this.form.mobile != 0) {


        let index = this.contacts.findIndex(obj =>
          (obj.mobile == this.form.mobile || obj.name === this.form.name)
        );

        //contact already exists
        if (index != -1) {
          this.message = 'Contact already exists';
          this.isContactedAdded = true;
          this.display();

        }
        else {
          this.userservice.addContact(this.form).subscribe();
          this.message = 'Contact added';
          this.isContactedAdded = true;
          this.display();

        }
      }
      else {
        this.message = 'Failed to add Contact.';
        this.isContactedAdded = true;
        this.display();

      }
    }

    this.handleClear(this.form);
    this.display();
  }

  handleClear(form) {

    form.name = " ";
    form.mobile = 0;
  }
}

