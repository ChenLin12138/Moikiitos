import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  loginUrl = "http://moikiitos.com/oauth/token";

  constructor(private http : HttpClient) { }

  doLogin(username : string, password : string) : Observable<boolean> {
    return this.http.post<{token : string}>(this.loginUrl,{username : username, password : password })
    .pipe(
      map(result => {
        localStorage.setItem('access_token', result.token);
        return true;
      })
    );
  }

  test(){
    return this.http.get("http://moikiitos.com/v1/moikiitos/feeds/1");
  }
}
