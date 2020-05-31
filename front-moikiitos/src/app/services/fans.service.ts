import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { User } from '../classes/user';
import { UserFollowView } from 'src/app/classes/userfollowview';


@Injectable({
  providedIn: 'root'
})
export class FansService {

  fansUrl : string =  "http://moikiitos.com/v1/moikiitos/follow/";
  searchUserUrl : string =  "http://moikiitos.com/v1/moikiitos/user/keyword/";

  constructor(private http : HttpClient) { }

  getRelationShip(userId : Number) : Observable<any>{
    let headers : HttpHeaders = new HttpHeaders({'Authorization':localStorage.getItem('access_token')});
    return this.http.get<any>(this.fansUrl+userId,{headers : headers});  
  }

  searchUserByKeyWord(keywords : String) : Observable<any>{
    let headers : HttpHeaders = new HttpHeaders({'Authorization':localStorage.getItem('access_token')});
    return this.http.get<any>(this.searchUserUrl+keywords,{headers : headers});
  }

  unFollow(map : UserFollowView) : Observable<any>{
    let headers : HttpHeaders = new HttpHeaders({'Authorization':localStorage.getItem('access_token')});
    this.http.delete(this.fansUrl,{headers : headers});
    return;
  }

  follow(map : UserFollowView) : Observable<any>{
    let headers : HttpHeaders = new HttpHeaders({'Authorization':localStorage.getItem('access_token')});
    return this.http.post(this.fansUrl,map,{headers : headers});
  }
}
