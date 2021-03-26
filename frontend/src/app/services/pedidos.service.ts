import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PedidosService {

  urlBase = 'localhost:8380';

  constructor(private http: HttpClient) { }

  getPedidos() {
    return this.http.get(`${this.urlBase}/pedidos`);
  }


}
