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
    const params : HttpParams = new HttpParams();
    const headers : HttpHeaders = new HttpHeaders();

    // params.set('username', 'tom');
    // params.set('password', '123');
    // params.set('client_id', 'organization');
    // params.set('client_secret', 'organization666');
    // params.set('grant_type', 'password');
    // params.set('scope', 'webclient');

    headers.set('Content-Type', 'application/form-data');
    // headers.set('Authorization','Basic');
    // headers.set('Authorization','Basic');
    // headers.set('Content-Type', 'application/json');

    // headers.set('Authorization','Basic '+btoa("client_id:organization,client_secret:organization666"));
    // headers.set('Authorization','Basic '+btoa("organization:organization666"));
    headers.set('Authorization','Basic b3JnYW5pemF0aW9uOm9yZ2FuaXphdGlvbjY2Ng==');

  

    let formData: FormData = new FormData(); 
    formData.append('username', 'tom'); 
    formData.append('password', '123'); 
    // formData.append('client_id', 'organization'); 
    // formData.append('client_secret', 'organization666'); 
    formData.append('grant_type', 'password'); 
    formData.append('scope', 'webclient'); 

    console.log(btoa("organization:organization666"));


    // return this.http.post<{token : string}>(this.loginUrl,{username : username, password : password})
    return this.http.post<{token : string}>(this.loginUrl ,formData, {headers})
    .pipe(
      map(result => {
        localStorage.setItem('access_token', result.token);
        return true;
      })
    );
  }

  test(username : string, password : string){
    return this.http.get("http://moikiitos.com/v1/moikiitos/feeds/1");
  }
}
