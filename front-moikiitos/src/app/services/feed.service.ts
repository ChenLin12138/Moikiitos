import { Injectable } from '@angular/core';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { UserFeed } from '../classes/userfeed';
import { Observable } from 'rxjs';
import { Feed } from '../classes/feed';

@Injectable({
  providedIn: 'root'
})
export class FeedService {

  // feedUrl : string = "http://moikiitos.com/v1/moikiitos/feeds/";
  // feedPostUrl : string =  "http://moikiitos.com/v1/moikiitos/feeds/";

  feedUrl : string = "http://localhost:8513/v1/moikiitos/feeds/";
  feedPostUrl : string =  "http://localhost:8513/v1/moikiitos/feeds/";

  constructor(
   private http: HttpClient
  ) { }

  getFeeds(userId : number) : Observable<UserFeed>{
    let headers : HttpHeaders = new HttpHeaders({'Authorization': 'Bearer '+localStorage.getItem('access_token')});
    return this.http.get<UserFeed>(this.feedUrl+userId,{headers : headers});
  }

  postFeed(feed : Feed) : Observable<any> {
    let headers : HttpHeaders = new HttpHeaders({'Authorization':'Bearer '+localStorage.getItem('access_token')});
    return this.http.post(this.feedPostUrl,feed,{headers : headers});
  }
}