import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ProdutoModel } from '../viewModel/produtos.view-model';
import { PedidoItemModel } from '../viewModel/pedido.view-model'

@Injectable({providedIn: 'root'})
export class CarrinhoService {

  produtos = new Array<PedidoItemModel>();

  constructor(private httpClient: HttpClient) { }

  resetCarrinho(): void {
    this.produtos = new Array();
  }

  adicionaItemPedido(produto: ProdutoModel): void {
    if(produto.estoque <= 0) return;

    const { id, custo, estoque, preco, idLoja } = produto;

    const produtoExiste = this.produtos.find(produtoExistente => produtoExistente.id_produto === id);

    const pedido: PedidoItemModel = {
      id_produto: id,
      valorUnitario: preco,
      quantidade: 1,
      valorTotal: preco
    };

    if (produtoExiste) {
      produtoExiste.quantidade +=1;
      produtoExiste.valorTotal = produtoExiste.quantidade * produtoExiste.valorUnitario;
    } else {
      this.produtos.push({
        id_produto: id,
        quantidade: 1,
        valorTotal: custo,
        valorUnitario: custo
      });
      produto.estoque -=1;
    }
  }

  enviarPedido(): boolean {
    return true;
  }
}
