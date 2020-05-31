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
    console.log("search");
    console.log(this.keyWords);
    this.fansService.searchUserByKeyWord(this.keyWords).subscribe(
      r =>{
        this.searchUsers = r;
        console.log(r);
      }
    );
  }

}
