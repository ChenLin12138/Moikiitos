import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { LoginService } from '../../services/login.service';
import { Router } from '@angular/router';
import { first } from 'rxjs/operators';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm;
  result;

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
    // this.loginService.test(data.name, data.password)
    .subscribe(
      res => {console.log(res)}
    )
    ;
    this.loginForm.reset();
  }

}
