import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class TrainService {
  salaryUrl : string = "http://moikiitos.com/v1/moikiitos/train/";

  constructor(
   private http: HttpClient
  ) { }

  getTrainInfo() : Observable<any>{
    let headers : HttpHeaders = new HttpHeaders({'Authorization': 'Bearer '+localStorage.getItem('access_token')});
    return this.http.get<any>(this.salaryUrl,{headers : headers});
  }
}
