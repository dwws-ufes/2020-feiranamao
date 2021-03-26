import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment.prod';
import { ServiceRequestViewModel } from '../viewModel/service-request.view-model';
import { OauthAccountViewModel } from '../viewModel/oauth.response.view-model';
import { map } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class AccountService {
  request: ServiceRequestViewModel = new ServiceRequestViewModel({});
  USER_NAME_SESSION_ATTRIBUTE_NAME = 'authenticatedUser'

  public username: string | undefined;
  public password: string| undefined;
  public grant_type: string | undefined;

  constructor(

    private httpClient: HttpClient,
  ) { }


  authenticationService(username: string, password: string) {

    var formData: any = new FormData();
    formData.append("grant_type",'password');
    formData.append("username", username);
    formData.append("password", password);

    return this.httpClient.post('http://localhost:4200/oauth/token'
    ,formData
    ,{ headers: { authorization: this.createBasicAuthToken('feiranamao', 'fer123@@') } })
    .pipe(map((res) => {

        const tokenData = new OauthAccountViewModel(res);
        console.log(tokenData.access_token);

        this.username = username;
        this.password = password;
        this.registerSuccessfulLogin(username, password);
      })
      );
  }

  createBasicAuthToken(username: string, password: string) {
    return 'Basic ' + window.btoa(username + ":" + password)
  }

  registerSuccessfulLogin(username: string, password: string) {
    sessionStorage.setItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME, username);
  }


  logout() {
    sessionStorage.removeItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME);
    this.username = undefined;
    this.password = undefined;
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME)
    if (user === null) return false
    return true
  }
}
