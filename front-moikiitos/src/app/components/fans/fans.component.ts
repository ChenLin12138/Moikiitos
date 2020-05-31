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

  followings : UserFollowView[];
  followers : UserFollowView[];
  userFollow : UserFollow = new UserFollow();
  searchUsers : User[];
  activeTable : number = 1;
  keyWords : String = "";

  constructor(private fansService : FansService) { }

  ngOnInit(): void {
    this.activeTable = 1;
    this.fansService.getRelationShip(Number(localStorage.getItem('user_id'))).subscribe(
      r => {
        this.followings = r.followingList;
        this.followers = r.followerList;
      }
    );
  }

  tabActive(tabNumber : number): void{
    this.activeTable = tabNumber;
  }

  onSearch(){
    this.activeTable = 3;
    this.fansService.searchUserByKeyWord(this.keyWords).subscribe(
      r =>{
        this.searchUsers = r;
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
