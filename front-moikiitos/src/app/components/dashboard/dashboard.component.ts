import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../services/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashBoardComponent implements OnInit {

  constructor(private loginService : LoginService, private router : Router) { }

  userName : string;

  ngOnInit(): void {
    this.userName = localStorage.getItem('user_name');
  }

  logout(){
    this.loginService.doLogout();
    this.router.navigateByUrl('user/login');
  }

}
