import { Component, Injectable, OnInit } from '@angular/core';
import { Issue } from '../models/Issue';
import { IssueService } from '../services/issue.service';

@Component({
  selector: 'app-issues-list',
  templateUrl: './issues-list.component.html',
  styleUrls: ['./issues-list.component.css']
})

@Injectable({
  providedIn: 'root',
})
export class IssuesListComponent implements OnInit {


  constructor(private issueService: IssueService) { }

  issues: Issue[] = [];
  index?: any;



  // Write logic to get all issues from IssueService
  ngOnInit() {
    this.issueService.getIssues().subscribe(data => {
      this.issues = data;
    });

  }



  display() {
    this.issueService.getIssues().subscribe(data => {
      this.issues = data;
    });
  }



  // Implement deleteIssue method to delete the issue
  deleteIssue(id: any) {
    this.display();
    this.issueService.deleteIssue(id).subscribe();
    this.display();

  }

}
