import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { User } from 'src/app/model/user';
import { RoutingService } from 'src/app/services/routing.service';
import { UserService } from 'src/app/services/user.service';
import { Validation } from './validation';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  form!: FormGroup;
  submitted = false;

  user: User = new User();
  users: User[] = [];
  errormessage = "";
type='password';
  adduser() {
    this.submitted = true;
    if (this.form.invalid) {
      return;
    }
    else {

      this.userService.adduser(this.form.value).subscribe({
        next: res => {
          alert('User Added: ' + res.username);
          this.form.reset();
          this.routingService.accessLogin();
        },
        error: error => { this.errormessage = error; }

      });

    }

  }

  get f() {
    return this.form.controls;
  }

  myFunction() {
   if(this.type==='password'){
    this.type='text';
   }
   else{
    this.type='password';
   }
  }

  constructor(private userService: UserService, private routingService: RoutingService) { }

  ngOnInit(): void {
    this.form = new FormGroup({
      username: new FormControl('', [Validators.required, Validators.minLength(6)]),
      password: new FormControl('', [Validators.required, Validators.minLength(6)]),
      confirmpassword: new FormControl('', [Validators.required]),
      email: new FormControl('', [Validators.required, Validators.email])

    }, { validators: [Validation.match('password', 'confirmpassword')] }
    )
  }
}

