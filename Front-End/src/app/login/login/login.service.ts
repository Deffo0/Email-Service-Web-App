import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http : HttpClient) { }

  createAccount(accountDetails:string) : Observable<string>{

    return this.http.post("http://localhost:8080/createFolder", accountDetails, {responseType : "text"});
  }
  loginToAccount(accountDetails:string) : Observable<string>{

    return this.http.post("http://localhost:8080/getFolder", accountDetails, {responseType : "text"});
  }
}