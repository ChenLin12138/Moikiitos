import { Injectable } from '@angular/core';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { JwtHelperService } from '@auth0/angular-jwt';
import { User } from '../classes/user';
import { SignupForm } from '../classes/signupform';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  currentUser : User = new User();  
  // loginUrl = "http://moikiitos.com/oauth/token";
  // signupUrl = "http://moikiitos.com/v1/moikiitos/user/"

  loginUrl = "http://localhost:8513/oauth/token";
  signupUrl = "http://localhost:8513/v1/moikiitos/user/"

  constructor(private http : HttpClient
              , private jwtHelperService: JwtHelperService
              ) { }

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
        localStorage.setItem('access_token', result.access_token);
        localStorage.setItem('refresh_token', result.refresh_token);
        this.currentUser = this.decodeUserFromToken(result.access_token);
        localStorage.setItem('user_id',JSON.stringify(this.currentUser.userId));
        localStorage.setItem('user_name',this.currentUser.userName);
        localStorage.setItem('user_roles',JSON.stringify(this.currentUser.roles));
        return true;
        })
      );
    }
  
  doSignup(username : string, password : string, email : string){
    let form : SignupForm = new  SignupForm();
    form.email = email;
    form.password = password;
    form.username = username;
    return this.http.post<any>(this.signupUrl ,form);
  }


  doLogout() : void{
    localStorage.removeItem('access_token');
    localStorage.removeItem('refresh_token');
    localStorage.removeItem('user_name');
    localStorage.removeItem('user_roles');
    localStorage.removeItem('user_id');
  }

  decodeUserFromToken(token) : User {
    this.currentUser.userId = this.jwtHelperService.decodeToken(token).user_id;
    this.currentUser.userName = this.jwtHelperService.decodeToken(token).user_name;
    this.currentUser.roles = this.jwtHelperService.decodeToken(token).authorities;
    return this.currentUser;
  }
}