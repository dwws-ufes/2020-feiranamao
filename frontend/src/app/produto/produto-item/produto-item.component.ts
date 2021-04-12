import { Component, Input, OnInit } from '@angular/core';
import { CarrinhoService } from 'src/app/services/carrinho.service';
import { ProdutoModel } from 'src/app/viewModel/produtos.view-model';

@Component({
  selector: 'f-produto-item',
  templateUrl: './produto-item.component.html',
  styleUrls: ['./produto-item.component.scss']
})
export class ProdutoItemComponent implements OnInit {

  @Input() produto!: ProdutoModel;

  constructor(private carrinhoService: CarrinhoService) {
  }

  ngOnInit(): void {
  }

  adicionarAoCarrinho(produto: ProdutoModel) {
    this.carrinhoService.adicionaItemPedido(produto);
  }

  removeDoCarrinho(produto: ProdutoModel) {
    this.carrinhoService.removeItemPedido(produto);
  }

  existeNoCarrinho(produto: ProdutoModel){
    return this.carrinhoService.existeItem(produto);
  }
}
