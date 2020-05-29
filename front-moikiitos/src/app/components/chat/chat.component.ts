import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { UserFeed } from '../../classes/userfeed'; 
import { FeedService } from 'src/app/services/feed.service';

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.css']
})
export class ChatComponent implements OnInit {

  public chatForm;

  userFeed : UserFeed = new UserFeed();

  constructor(private formBuilder : FormBuilder, private feedService : FeedService) { 
    this.chatForm = this.formBuilder.group({
      content : ''
    });
  }

  ngOnInit(): void {
    this.feedService.getFeeds(Number(localStorage.getItem('user_id'))).subscribe(
     result => this.userFeed = result
    );
  
  }

  onSubmit(data) {

    console.log(data);
    // this.loginService.doLogout();
    // this.loginService.doLogin(data.name, data.password)
    // .subscribe(
     
    // );
  }

}
