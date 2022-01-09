import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SalaryService {

  salaryUrl : string = "http://moikiitos.com/v1/moikiitos/salary/";

  constructor(
   private http: HttpClient
  ) { }

  getSalaryInfo() : Observable<any>{
    let headers : HttpHeaders = new HttpHeaders({'Authorization': 'Bearer '+localStorage.getItem('access_token')});
    return this.http.get<any>(this.salaryUrl,{headers : headers});
  }
}
