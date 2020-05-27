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
  public result;
  public error : string ;
  

  constructor(private formBuilder : FormBuilder, private loginService : LoginService, private router : Router) { 
    this.loginForm = this.formBuilder.group({
      name : ''
      ,password : ''
    })
  }

  ngOnInit(): void {
  }

  onSubmit(data) {
    console.log('Your order has been submitted', data);
    this.loginService.doLogin(data.name, data.password)
    .subscribe(
      result => this.router.navigateByUrl('main'),
      err => this.error = 'Could not authenticate'
    );
  }
}
