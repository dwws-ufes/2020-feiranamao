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
  contador: number = 0;

  constructor(private carrinhoService: CarrinhoService) {
  }

  ngOnInit(): void {
    this.contador = this.carrinhoService.quantidadeItem(this.produto.id);
  }

  adicionarAoCarrinho(produto: ProdutoModel) {
    this.carrinhoService.adicionaItemPedido(produto);
    this.contador = this.carrinhoService.quantidadeItem(produto.id);
  }

  removeDoCarrinho(produto: ProdutoModel) {
    this.carrinhoService.removeItemPedido(produto);
    this.contador = this.carrinhoService.quantidadeItem(produto.id);
  }

  existeNoCarrinho(produto: ProdutoModel){
    return this.carrinhoService.quantidadeItem(produto.id) > 0;
  }
}
