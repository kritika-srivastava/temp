import { Component, Injectable, OnInit } from '@angular/core';
import { FormBuilder, FormControl, Validators } from '@angular/forms';
import { IssuesListComponent } from '../issues-list/issues-list.component';
import { Issue } from '../models/Issue';
import { IssueService } from '../services/issue.service';

@Component({
  selector: 'app-issue',
  templateUrl: './issue.component.html',
  styleUrls: ['./issue.component.css']
})

@Injectable({
  providedIn: 'root',
})
export class IssueComponent implements OnInit {

  // Form is created in html file and write code to make it functional using FormBuilder


  form;
  constructor(private issueService: IssueService, private issuesList: IssuesListComponent, private fb: FormBuilder) {
    this.form = this.fb.group({
      title: this.fb.control('', Validators.required),
      description: this.fb.control('', Validators.required)
    });
  }

  // message to be display if Issue added or not
  message = '';



  // Write logic to make all fields as mandatory

  ngOnInit() {
  }

  // Implement onSubmit method to save a Issue, verify form is valid or not
  // Display message 'Title and Description should not be empty!!! Please verify details' if form is invalid
  // Display message 'Failed to add Issue!!' while error handling
  // Display message 'Issue added' if Issue is added
  onSubmit() {

    if (this.form.get('title').value != undefined && this.form.get('description').value != undefined) {
      if (this.form.get('title').value.toString() === '' || this.form.get('description').value.toString() == '') {

        this.message = "Title and Description should not be empty!!! Please verify details";
      }
      else {
        let issue = new Issue();

        issue.title = String(this.form.get('title').value);
        issue.description = this.form.get('description').value.toString();

        // console.log(issue.title);
        // console.log(issue.description);
        this.issueService.addIssue(issue).subscribe();

        this.message = "Issue added";
        this.clearForm();
      }
    }
    else {

      this.message = "Failed to add Issue!!";

    }
  }
  // clearForm method is to reset the form after submitting
  clearForm() {
    this.form.reset();
  }
}
