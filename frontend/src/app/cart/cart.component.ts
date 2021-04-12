import { Component, OnInit } from '@angular/core';
import { CarrinhoService } from '../services/carrinho.service';
import { PedidoItemModel } from '../viewModel/pedido.view-model';

@Component({
  selector: 'f-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.scss']
})
export class CartComponent implements OnInit {

  produtos = new Array<PedidoItemModel>();
  descricao: string = '';

  constructor(private carrinhoService: CarrinhoService) { }

  ngOnInit(): void {
    this.produtos = this.carrinhoService.produtos;

  }

  enviarPedido(observacao: string) {
    this.carrinhoService.enviarPedido(observacao);
  }

}
