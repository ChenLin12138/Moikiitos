import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { UserFeed } from '../../classes/userfeed'; 
import { FeedService } from 'src/app/services/feed.service';
import { Feed } from 'src/app/classes/feed';
import { Router } from '@angular/router';


@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.css']
})
export class ChatComponent implements OnInit {

  public chatForm;

  userFeed : UserFeed = new UserFeed();
  postFeed : Feed = new Feed();

  constructor(private formBuilder : FormBuilder 
              ,private feedService : FeedService
              ,private router : Router)
              { 
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
    this.postFeed.content = data.content;
    this.postFeed.userid = Number(localStorage.getItem('user_id'));
    this.feedService.postFeed(this.postFeed).subscribe(
      // result => this.router.navigateByUrl('main/chat')
      result => {
        console.log(result);
        this.ngOnInit();
      }
    );
  }

}
