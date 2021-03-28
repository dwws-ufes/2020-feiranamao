import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { AccountService } from '../login/account.service';

@Injectable({
  providedIn: 'root'
})
export class CrudService {

  constructor(
    private http: HttpClient,
    private accountService: AccountService
  ) { }

  getGenerico<T>(endpoint: string, param?:string) {

    let url = `${environment.URL_API}/${endpoint}`;

    if(param) url = `${url}/${param}`;

    return this.http.get<T>(
      url
    ,{ headers: { Authorization: 'Bearer '+ this.accountService.getToken() } })
  }

  postGenerico<T>(endpoint:string, body: Object) {

    let url = `${environment.URL_API}/${endpoint}`;

    return this.http.post<T>(
      url
    ,{ headers: { Authorization: 'Bearer '+ this.accountService.getToken() } }
    ,body
    )
  }

}
