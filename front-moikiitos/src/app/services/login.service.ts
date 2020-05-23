import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  loginUrl = "http://moikiitos.com/oauth/token";

  constructor(private http : HttpClient) { }

  // doLogin(data) {
  //   return this.http.post(loginUrl,)
  // }

  test(){
    return this.http.get("http://moikiitos.com/v1/moikiitos/feeds/1");
  }
}
