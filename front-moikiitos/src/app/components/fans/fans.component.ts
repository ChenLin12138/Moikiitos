import { Component, OnInit } from '@angular/core';
import { FansService } from 'src/app/services/fans.service';
import { User } from '../../classes/user';
import { UserFollowView } from 'src/app/classes/userfollowview';
import { UserFollow } from 'src/app/classes/userfollow';

@Component({
  selector: 'app-fans',
  templateUrl: './fans.component.html',
  styleUrls: ['./fans.component.css']
})
export class FansComponent implements OnInit {

  tabIndex : number = 0;
  keyWords : String = "";

  tabs = [
    {
    "tabname" : "Following"
    ,"list" : [""]
    }
    ,{
      "tabname" : "Followers"
      ,"list" : [""]
    }
    ,{
      "tabname" : "Search"
      ,"list" : [""] 
    }
  ]

  constructor(private fansService : FansService) { }

  ngOnInit(): void {
    // this.activeTable = 1;
    this.fansService.getRelationShip(Number(localStorage.getItem('user_id'))).subscribe(
      r => {
        // this.followings = r.followingList;
        this.tabs[0].list = r.followingList;
        // this.followers = r.followerList;
        this.tabs[1].list = r.followerList;
      }
    );
  }

  onSearch(){
    this.fansService.searchUserByKeyWord(this.keyWords).subscribe(
      r =>{
        this.tabIndex = 2;
        this.tabs[2].list = r;
        console.log(this.tabs[2].list);
      }
    );
  }

  onUnFollow(userFollowId : number){
    this.fansService.unFollow(userFollowId).subscribe(
      r => {
        this.ngOnInit();
      }
    );
  }

  onFollow(toFollowId : number){
    let userFollow : UserFollow = new UserFollow();
    userFollow.followid = toFollowId;
    userFollow.userid = Number(localStorage.getItem('user_id'));
    this.fansService.follow(userFollow).subscribe(
      r => {
        this.ngOnInit();
      }
    );
  }

}
