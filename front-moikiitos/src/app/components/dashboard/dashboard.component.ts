import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashBoardComponent implements OnInit {

  constructor() { }

  userName : string;

  ngOnInit(): void {
    this.userName = localStorage.getItem('user_name');
  }

}
