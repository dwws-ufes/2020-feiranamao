import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { ServiceRequestViewModel } from '../viewModel/service-request.view-model';
import { OauthAccountViewModel } from '../viewModel/oauth.response.view-model';
import { map } from 'rxjs/operators';
import { UsuarioService } from './usuario.service';


@Injectable({
  providedIn: 'root'
})
export class AccountService {
  request: ServiceRequestViewModel = new ServiceRequestViewModel({});
  USER_NAME_SESSION_ATTRIBUTE_NAME = 'authenticatedUser'
  JWT_SESSION_ATTRIBUTE_NAME = 'authenticatedJwt'

  public username: string | undefined;
  public password: string| undefined;
  public grant_type: string | undefined;

  public dono: boolean = false;

  constructor(
    private httpClient: HttpClient,
    // private usuarioService: UsuarioService
  ) { }


  authenticationService(username: string, password: string) {

    var formData: any = new FormData();
    formData.append("grant_type",'password');
    formData.append("username", username);
    formData.append("password", password);

    let urlToken = 'oauth/token';
    let url = `${environment.URL_API}/${urlToken}`;

    return this.httpClient.post(url
    ,formData
    ,{ headers: { authorization: this.createBasicAuthToken('feiranamao', 'fer123@@') } })
    .pipe(map((res) => {

        const tokenData = new OauthAccountViewModel(res);
        console.log(tokenData.access_token);

        this.username = username;
        this.password = password;
        this.registerSuccessfulLogin(username, password, tokenData.access_token);

        this.getDetalhesUsuarioLogado();
      })
      );
  }

  createBasicAuthToken(username: string, password: string) {
    return 'Basic ' + window.btoa(username + ":" + password)
  }

  registerSuccessfulLogin(username: string, password: string, acess_token: string) {
    this.logout();
    sessionStorage.setItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME, username);
    sessionStorage.setItem(this.JWT_SESSION_ATTRIBUTE_NAME, acess_token);
  }

  getDetalhesUsuarioLogado() {
    // this.usuarioService.getUsuario().subscribe(user => this.dono = user.dono);
  }


  logout() {
    sessionStorage.removeItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME);
    sessionStorage.removeItem(this.JWT_SESSION_ATTRIBUTE_NAME);
    this.username = undefined;
    this.password = undefined;
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME)
    if (user === null) return false
    return true
  }

  getUserLoggedIn() {
    let user = sessionStorage.getItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME)
    return user
  }

  getToken() {
    let user = sessionStorage.getItem(this.JWT_SESSION_ATTRIBUTE_NAME)
    return user
  }

}
