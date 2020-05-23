import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { LoginService } from '../../services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm;
  result;

  constructor(private formBuilder : FormBuilder, private loginService : LoginService) { 
    this.loginForm = this.formBuilder.group({
      name : ''
      ,password : ''
    })
  }

  ngOnInit(): void {
  }

  onSubmit(data) {
    console.log('Your order has been submitted', data);
    this.loginService.test().subscribe(res => {
      this.result = res;
      console.log(this.result);
    });
    this.loginForm.reset();
  }

}
