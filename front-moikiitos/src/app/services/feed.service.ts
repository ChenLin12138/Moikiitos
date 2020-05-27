import { Injectable } from '@angular/core';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { UserFeed } from '../classes/userfeed';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FeedService {

  feedUrl : string = "http://moikiitos.com/v1/moikiitos/feeds/";

  constructor(
   private http: HttpClient
  ) { }

  getFeeds(userId : number) : Observable<UserFeed>{
    let headers : HttpHeaders = new HttpHeaders({'Authorization':localStorage.getItem('access_token')});
    return this.http.get<UserFeed>(this.feedUrl+userId,{headers : headers});
  }
}
