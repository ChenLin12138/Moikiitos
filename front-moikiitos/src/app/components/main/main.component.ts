import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../services/login.service';
import { Router } from '@angular/router';
import { FeedService } from 'src/app/services/feed.service';
import { MenuService } from 'src/app/services/menu.service';
import { UserFeed } from '../../classes/userfeed'; 

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {

  selected : boolean = false;

  mode = false;
  dark = false;
  
  childrenMenu = {
    level : 2,
    title: 'oper1',
    icon: '',
    selected: false,
    disabled: false
  }

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
    },
    {
      level: 1,
      title: 'Oper Group',
      icon: 'appstore',
      open: false,
      selected: false,
      disabled: false,
      children: []
    },
  ];

  constructor(private loginService : LoginService
    ,private router : Router
    ,private feedService : FeedService 
    ,private menuService : MenuService
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
  
    this.menuService.getMenusByUserId(Number(localStorage.getItem('user_id'))).subscribe(
      result => {
        for(var i = 0; i < result.length ; i ++){
          this.childrenMenu.title = result[i].name;
          this.menus[2].children.push(this.childrenMenu);    
        }
      }
    );
  }

  test(){
    console.log("Test");
  }

  logout(){
    this.loginService.doLogout();
    this.router.navigateByUrl('user/login');
  }

  onMenuClick(title : string) {

    if(title.startsWith('Following')||title.startsWith('Follower')){
      this.router.navigateByUrl('main/fans');
    }else{
      this.router.navigateByUrl('main/'+title.toLowerCase());
    }
  }  

}
