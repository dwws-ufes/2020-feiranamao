import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { AccountService } from './account.service';

@Injectable({
  providedIn: 'root'
})
export class CrudService {

  constructor(
    private http: HttpClient,
    private accountService: AccountService
  ) { }

   auth = 'Bearer '+ this.accountService.getToken();

  httpOptions = {
    headers: new HttpHeaders()
      .set('Content-Type', 'application/json')
      .set('Authorization', this.auth)
  }

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
    ,JSON.stringify(body)
    ,this.httpOptions
    )
  }

  deleteGenerico<T>(endpoint:string, param?:string){
    let url = `${environment.URL_API}/${endpoint}`;

    if(param) url = `${url}/${param}`;

    return this.http.delete<T>(
      url
    ,this.httpOptions
    )
  }

}
