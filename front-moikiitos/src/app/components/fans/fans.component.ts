import { Component, OnInit } from '@angular/core';
import { FansService } from 'src/app/services/fans.service';
import { User } from '../../classes/user';

@Component({
  selector: 'app-fans',
  templateUrl: './fans.component.html',
  styleUrls: ['./fans.component.css']
})
export class FansComponent implements OnInit {

  followings : User[];
  followers : User[];

  constructor(private fansService : FansService) { }

  ngOnInit(): void {
    this.fansService.getRelationShip(Number(localStorage.getItem('user_id'))).subscribe(
      r => {
        this.followings = r.followingList;
        this.followers = r.followerList;
      }
    );
  }

}
