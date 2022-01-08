import { Injectable } from '@angular/core';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { Menu } from '../classes/menu';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MenuService {

  feedUrl : string = "http://moikiitos.com/v1/moikiitos/user/";

  constructor(
   private http: HttpClient
  ) { }

  getMenusByUserId(userId : number) : Observable<any>{
    let headers : HttpHeaders = new HttpHeaders({'Authorization': 'Bearer '+localStorage.getItem('access_token')});
    return this.http.get<any>(this.feedUrl+userId+"/menu",{headers : headers});
  }
}