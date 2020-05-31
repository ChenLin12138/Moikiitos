import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { User } from '../classes/user';

@Injectable({
  providedIn: 'root'
})
export class FansService {

  fansUrl : string =  "http://moikiitos.com/v1/moikiitos/follower/";
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

}
