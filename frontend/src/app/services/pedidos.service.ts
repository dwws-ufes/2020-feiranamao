import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CrudService } from './crud.service';

interface ItemPedidoModel {
  id: number,
  valorUnitario: number,
  quantidade: number,
  valorTotal: number,
  id_produto: number
}
interface PedidoModel {
  id: number,
  itemPedido: ItemPedidoModel[],
  id_loja: number,
  obs: string
}
@Injectable({providedIn: 'root'})
export class PedidosService {

  constructor(private crudService: CrudService) { }

  getPedidos() {
    return this.crudService.getGenerico('pedidos');
  }
}
