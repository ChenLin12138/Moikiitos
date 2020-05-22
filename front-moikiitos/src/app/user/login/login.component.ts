import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm;

  constructor(private formBuilder : FormBuilder) { 
    this.loginForm = this.formBuilder.group({
      name : ''
      ,password : ''
    })
  }

  ngOnInit(): void {
  }

  onSubmit(data) {
    console.log('Your order has been submitted', data);
    this.loginForm.reset();
  }

}
