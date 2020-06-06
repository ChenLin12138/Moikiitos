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

  validateForm!: FormGroup;
  public error : string ;

  submitForm(): void {
    for (const i in this.validateForm.controls) {
      this.validateForm.controls[i].markAsDirty();
      this.validateForm.controls[i].updateValueAndValidity();
    }

    if(localStorage.getItem('access_token') && localStorage.getItem('user_name')==this.validateForm.value.username){
      this.router.navigateByUrl('main');
    }

    this.loginService.doLogout();
    this.loginService.doLogin(this.validateForm.value.username, this.validateForm.value.password)
    .subscribe(
      result => this.router.navigateByUrl('main/chat'),
      err => this.error = 'Could not authenticate'
    );
  }

  constructor(private fb: FormBuilder, private loginService : LoginService, private router : Router) {}

  ngOnInit(): void {
    this.validateForm = this.fb.group({
      username: [null, [Validators.required]],
      password: [null, [Validators.required]],
    });
  }

  // public loginForm;
  // public signupForm;
  // public result;
  // public error : string ;
  // public page : number;

  // constructor(private formBuilder : FormBuilder, private loginService : LoginService, private router : Router) { 
  //   this.loginForm = this.formBuilder.group({
  //     name : ''
  //     ,password : ''
  //   })

  //   this.signupForm = this.formBuilder.group({
  //     name : ''
  //     ,email : ''
  //     , password : ''
  //     ,passwordConfirm : ''
  //   })
  // }

  // ngOnInit(): void {
  //   this.page=1;
  // }

  // onLogin(data) {

  //   if(localStorage.getItem('access_token') && localStorage.getItem('user_name')==data.name){
  //     this.router.navigateByUrl('main');
  //   }

  //   this.loginService.doLogout();
  //   this.loginService.doLogin(data.name, data.password)
  //   .subscribe(
  //     result => this.router.navigateByUrl('main/chat'),
  //     err => this.error = 'Could not authenticate'
  //   );
  // }

  // onSignup(data) {
  //   console.log(data);
  //   if(data.password != data.passwordConfirm){
  //     return ;
  //   }
  //   this.loginService.doSignup(data.name, data.password, data.email).subscribe(
  //     r => this.ngOnInit()
  //   );
  // }

  // pageActive(page : number) {
  //   this.page = page;
  // }
}
