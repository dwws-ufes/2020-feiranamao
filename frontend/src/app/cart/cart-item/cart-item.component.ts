import { Component, OnInit, Input } from '@angular/core';
import { PedidoItemModel } from 'src/app/viewModel/pedido.view-model';
import { ProdutoModel } from 'src/app/viewModel/produtos.view-model';

@Component({
  selector: 'f-cart-item',
  templateUrl: './cart-item.component.html',
  styleUrls: ['./cart-item.component.scss']
})
export class CartItemComponent implements OnInit {

  @Input() produto!: PedidoItemModel;

  constructor() { }

  ngOnInit(): void {
  }

}
