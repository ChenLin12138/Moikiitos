import { Injectable } from '@angular/core';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  loginUrl = "http://moikiitos.com/oauth/token";

  constructor(private http : HttpClient) { }

  doLogin(username : string, password : string) : Observable<boolean> {
    let headers : HttpHeaders = new HttpHeaders();
    headers = headers.set('Authorization','Basic '+btoa("organization:organization666"));
    let formData: FormData = new FormData(); 
    formData.set('username', username); 
    formData.set('password', password);  
    formData.set('grant_type', 'password'); 
    formData.set('scope', 'webclient'); 

    // return this.http.post<{token : string}>(this.loginUrl,{username : username, password : password})
    return this.http.post<{token : string}>(this.loginUrl ,formData, {headers : headers})
    .pipe(
      map(result => {
        console.log(result);
        localStorage.setItem('access_token', result.token);
        return true;
      })
    );
  }

  test(username : string, password : string){
    return this.http.get("http://moikiitos.com/v1/moikiitos/feeds/1");
  }
}