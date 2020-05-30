import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FansService {

  fansUrl : string =  "http://moikiitos.com/v1/moikiitos/follower/";
  constructor(private http : HttpClient) { }

  getRelationShip(userId : Number) : Observable<any>{
    let headers : HttpHeaders = new HttpHeaders({'Authorization':localStorage.getItem('access_token')});
    return this.http.get<any>(this.fansUrl+userId,{headers : headers});  
  }
}
