import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { User } from 'src/app/model/user';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-user-detail',
  templateUrl: './user-detail.component.html',
  styleUrls: ['./user-detail.component.css']
})
export class UserDetailComponent implements OnInit {


  user!: User;


  constructor(private userService: UserService, private route: ActivatedRoute) { }

  getuserbyId() {

    const id = this.route.snapshot.paramMap.get('id');
    this.userService.fetchuserById(id).subscribe(res => this.user = res);
  }

  ngOnInit(): void {
    this.getuserbyId();
  }


}
