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

    //pipe其实就是angular中的filter
    //map会让数组中每一个元素执行定义的函数，并返回数组
    return this.http.post<any>(this.loginUrl ,formData, {headers : headers})
    .pipe(
      map(result => {
        console.log(result);
        //获取token放入localStorage中
        localStorage.setItem('access_token', result.access_token);
        localStorage.setItem('refresh_token', result.refresh_token);
        return true;
      })
    );
  }

  test(username : string, password : string){
    return this.http.get("http://moikiitos.com/v1/moikiitos/feeds/1");
  }
}