import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { UserFollow } from '../classes/userfollow';


@Injectable({
  providedIn: 'root'
})
export class FansService {

  // fansUrl : string =  "http://moikiitos.com/v1/moikiitos/follow/";
  // searchUserUrl : string =  "http://moikiitos.com/v1/moikiitos/user/keyword/";

  fansUrl : string =  "http://localhost:8513/v1/moikiitos/follow/";
  searchUserUrl : string =  "http://localhost:8513/v1/moikiitos/user/keyword/";

  constructor(private http : HttpClient) { }

  getRelationShip(userId : Number) : Observable<any>{
    let headers : HttpHeaders = new HttpHeaders({'Authorization':'Bearer '+localStorage.getItem('access_token')});
    return this.http.get<any>(this.fansUrl+userId,{headers : headers});  
  }

  searchUserByKeyWord(keywords : String) : Observable<any>{
    let headers : HttpHeaders = new HttpHeaders({'Authorization':'Bearer '+localStorage.getItem('access_token')});
    return this.http.get<any>(this.searchUserUrl+keywords,{headers : headers});
  }

  unFollow(id : Number) : Observable<any>{
    let headers : HttpHeaders = new HttpHeaders({'Authorization':'Bearer '+localStorage.getItem('access_token')});
    return this.http.delete(this.fansUrl+id,{headers : headers});
  }

  follow(map : UserFollow) : Observable<any>{
    let headers : HttpHeaders = new HttpHeaders({'Authorization':'Bearer '+localStorage.getItem('access_token')});
    return this.http.post(this.fansUrl+map.userid,map,{headers : headers});
  }
}
