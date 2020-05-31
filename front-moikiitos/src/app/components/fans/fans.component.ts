import { Component, OnInit } from '@angular/core';
import { FansService } from 'src/app/services/fans.service';
import { User } from '../../classes/user';
import { UserFollowView } from 'src/app/classes/userfollowview';

@Component({
  selector: 'app-fans',
  templateUrl: './fans.component.html',
  styleUrls: ['./fans.component.css']
})
export class FansComponent implements OnInit {

  followings : UserFollowView[];
  followers : UserFollowView[];
  searchUsers : User[];
  activeTable : number = 1;
  keyWords : String = "";
  userFollowView : UserFollowView;

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

  onUnFollow(followId : number){
    // this.userFollowView.userId = Number(localStorage.getItem('user_id'));
    // this.relationMap.followid = followId;
    // this.fansService.unFollow(this.relationMap).subscribe(
    //   r => {
    //     this.ngOnInit();
    //   }
    // );
  }

}
