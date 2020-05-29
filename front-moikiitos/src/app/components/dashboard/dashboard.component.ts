import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../services/login.service';
import { Router } from '@angular/router';
import { FeedService } from 'src/app/services/feed.service';
import { UserFeed } from '../../classes/userfeed'; 

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashBoardComponent implements OnInit {

  constructor(private loginService : LoginService
              ,private router : Router
              ,private feedService : FeedService 
              ) { }

  userFeed : UserFeed = new UserFeed();
  testuserId : number;


  ngOnInit(): void {
    this.feedService.getFeeds(Number(localStorage.getItem('user_id'))).subscribe(
      result => {
        this.userFeed.userName = result.userName;
        this.userFeed.followingCount = result.followingCount;
        this.userFeed.followersCount = result.followersCount;
        this.testuserId = Number(localStorage.getItem('user_id'));
      }
    );
  }
}
