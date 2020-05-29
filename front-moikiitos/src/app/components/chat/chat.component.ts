import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { config } from 'rxjs';

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.css']
})
export class ChatComponent implements OnInit {

  public chatForm;

  constructor(private formBuilder : FormBuilder) { 
    this.chatForm = this.formBuilder.group({
      content : ''
    });
  }

  ngOnInit(): void {
  }

  onSubmit(data) {

    console.log(data);
    // this.loginService.doLogout();
    // this.loginService.doLogin(data.name, data.password)
    // .subscribe(
     
    // );
  }

}
