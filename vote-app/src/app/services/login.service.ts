import { Injectable, NgZone } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  readonly urlLogin = 'http://localhost:9765/login';
  readonly urlLogout = 'http://localhost:9765/login/out';
  readonly urlSessions = 'http://localhost:9765/sessions';

  constructor(private httpClient: HttpClient, private zone: NgZone) { }

  signIn(formData: any) {
    return this.httpClient.post(this.urlLogin, formData);
  }

  getSessions(){
    return this.httpClient.get(this.urlSessions);
  }

  signOut(formData: any){
    return this.httpClient.post(this.urlLogout, formData);
  }

}
