import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../services/login.service';
import { Router } from '@angular/router';
import { FeedService } from 'src/app/services/feed.service';
import { UserFeed } from '../../classes/userfeed'; 

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {

  mode = false;
  dark = false;
  menus = [
    {
      level: 1,
      title: 'Follow Group',
      icon: 'team',
      open: false,
      selected: false,
      disabled: false,
      children: [
        {
          level: 2,
          title: 'Following',
          icon: 'user',
          selected: false,
          disabled: false
        },
        {
          level: 2,
          title: 'Follower',
          icon: 'user',
          selected: false,
          disabled: false
        }
      ]
    },
    {
      level: 1,
      title: 'Chat Group',
      icon: 'mail',
      open: false,
      selected: false,
      disabled: false,
      children: [
        {
          level: 2,
          title: 'Chat',
          icon: 'message',
          selected: false,
          disabled: false
        }
      ]
    }
  ];

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
        this.menus[0].children[0].title = "Following "+result.followingCount
        this.menus[0].children[1].title = "Follower "+result.followersCount
      }
    );
  }

  logout(){
    this.loginService.doLogout();
    this.router.navigateByUrl('user/login');
  }

}
