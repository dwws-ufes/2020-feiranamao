import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { AuthResponse } from 'app/main/apps/contacts/auth.model';
import { map } from 'rxjs/operators';
import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
  export class AuthenticationService {

    
    authResponse: AuthResponse;
  
    BASE_PATH: 'http://localhost:8080'
    USER_NAME_SESSION_ATTRIBUTE_NAME = 'authenticatedUser'
    ACCESS_TOKEN_SESSION_ATTRIBUTE_NAME = 'acessToken'
    AUTH_API = 'http://localhost:8380/api/auth/';

    public username: String;
    public password: String;
  
    constructor(private http: HttpClient,  private router: Router) {
  
    }
  
    authenticationService(username: String, password: String) {
      return this.http.post( '/oauth/token'+ '?'+this.buildParams(username, password).toString() ,''
      ).subscribe((res: AuthResponse)  => {

          this.authResponse = res;
          this.username = username;
          this.password = password;
          this.registerSuccessfullLogin(this.username);
          this.registerSuccessfullToken( this.authResponse.access_token);

          if(this.isUserLoggedIn()){
            this.router.navigate(['/dashboards/analytics']);
      
         }

        });
    }
  
    buildParams(username, password){

      return new HttpParams()
      .append('username', 'paola')
      .append('password', 'LeO345ab')
      .append('grant_type', 'password');
  };
  
    registerSuccessfullLogin(username) {
      sessionStorage.setItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME, username)
    }

    registerSuccessfullToken(key) {
      sessionStorage.setItem(this.ACCESS_TOKEN_SESSION_ATTRIBUTE_NAME, key)
    }
  
    logout() {
      sessionStorage.removeItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME);
      this.username = null;
      this.password = null;
    }
  
    isUserLoggedIn() {
      let user = sessionStorage.getItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME)
      if (user === null) return false
      return true
    }
  
    getLoggedInUserName() {
      let user = sessionStorage.getItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME)
      if (user === null) return ''
      return user
    }

    getAcessToken() {
      let key = sessionStorage.getItem(this.ACCESS_TOKEN_SESSION_ATTRIBUTE_NAME)
      if (key === null) return ''
      return key
    }

    getBasicToken() {
     return this.createBasicAuthToken();
    }

    createBasicAuthToken() {
      return window.btoa("itout:it111@@")
    }

  }