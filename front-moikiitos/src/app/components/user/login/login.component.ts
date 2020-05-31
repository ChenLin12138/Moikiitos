import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { LoginService } from '../../../services/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public loginForm;
  public signupForm;
  public result;
  public error : string ;
  public page : number;
  
  

  constructor(private formBuilder : FormBuilder, private loginService : LoginService, private router : Router) { 
    this.loginForm = this.formBuilder.group({
      name : ''
      ,password : ''
    })

    this.signupForm = this.formBuilder.group({
      name : ''
      ,email : ''
      , password : ''
      ,passwordConfirm : ''
    })
  }

  ngOnInit(): void {
    this.page=1;
  }

  onLogin(data) {

    if(localStorage.getItem('access_token') && localStorage.getItem('user_name')==data.name){
      this.router.navigateByUrl('main');
    }

    this.loginService.doLogout();
    this.loginService.doLogin(data.name, data.password)
    .subscribe(
      result => this.router.navigateByUrl('main/chat'),
      err => this.error = 'Could not authenticate'
    );
  }

  onSignup(data) {
    console.log(data);
    if(data.password != data.passwordConfirm){
      return ;
    }
    this.loginService.doSignup(data.name, data.password, data.email).subscribe(
      r => this.ngOnInit()
    );
  }

  pageActive(page : number) {
    this.page = page;
  }
}
