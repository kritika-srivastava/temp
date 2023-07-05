import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { BlogService } from '../services/blog.service';

@Component({
  selector: 'app-blog',
  templateUrl: './blog.component.html',
  styleUrls: ['./blog.component.css']
})
export class BlogComponent implements OnInit {

  form;

  // message to be display if blog added or not
  message = '';

  // Form is created in html file and write code to make it functional using FormBuilder
  // Write logic to make all fields as mandatory for form and check email is valid or not
  /*
    title?: string;
    authorName?: string;
    email?: string;
    content?: string;
  */
  constructor(private fb: FormBuilder, private blogService: BlogService) {

    this.form = this.fb.group({
      title: this.fb.control('', Validators.required),
      authorName: this.fb.control('', Validators.required),
      email: this.fb.control('', [Validators.required, Validators.email]),
      content: this.fb.control('', Validators.required)
    });
  }



  ngOnInit() {
  }

  // Implement onSubmit method to save a Blog, verify form is valid or not
  // Display message 'Please verify entered details!!!' if form is invalid
  // Display message 'Blog added' if Blog is added
  // Display message 'Failed to add Blog!!' while error handling
  onSubmit() {
    if (this.form.invalid) {
      this.message = 'Please verify entered details!!!';
      return;
    }
    else {
      this.blogService.addBlog(this.form.value).subscribe({
        next: res => {
          this.clearForm();
          this.message = 'Blog added';
        },
        error: error => {
          this.message = 'Failed to add Blog!!';
        }
      });


    }
  }

  // clearForm method is to reset the form after submitting
  clearForm() {
this.form.reset();
  }
}
