
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ProdutoModel } from '../viewModel/produtos.view-model';
import { PedidoItemModel, PedidoModel } from '../viewModel/pedido.view-model'
import { CrudService } from './crud.service';

@Injectable({providedIn: 'root'})
export class CarrinhoService {

  produtos = new Array<PedidoItemModel>();

  constructor(private httpClient: HttpClient, private crudService: CrudService) { }

  resetCarrinho(): void {
    this.produtos = new Array();
  }

  adicionaItemPedido(produto: ProdutoModel): void {
    console.log(produto)
    if(produto.estoque <= 0) return;

    const { id, name, url, descricao, estoque, preco, idLoja } = produto;

    const produtoExiste = this.produtos.find(produtoExistente => produtoExistente.id_produto === id);

    const pedido: PedidoItemModel = {
      id_produto: id,
      valorUnitario: preco,
      quantidade: 1,
      valorTotal: preco,
      name: name,
      descricao: descricao,
      url: url,
      estoque: estoque,
      idLoja: idLoja.id
    };

    if (produtoExiste) {
      produtoExiste.quantidade +=1;
      produtoExiste.valorTotal = produtoExiste.quantidade * produtoExiste.valorUnitario;
    } else {
      this.produtos.push(pedido);
    }
    produto.estoque -=1;
    console.log(this.produtos)
  }

  removeItemPedido(produto: ProdutoModel): void {
    console.log(produto)
    if(this.produtos.length === 0) return;

    const { id, name, url, descricao, estoque, preco, idLoja } = produto;

    const produtoExiste = this.produtos.find(produtoExistente => produtoExistente.id_produto === id);

    if (produtoExiste) {
      produtoExiste.quantidade -=1;
      produtoExiste.valorTotal -= produtoExiste.valorUnitario;
    } else {
      return;
    }
    if(produtoExiste.quantidade<=0)
      this.produtos = this.produtos.filter(produto => produto.id_produto != produtoExiste.id_produto )
    produto.estoque +=1;
    console.log(this.produtos)
  }

  existeItem(produto: ProdutoModel): number | undefined {
    const { id } = produto;
    const produtoExiste = this.produtos.find(produtoExistente => produtoExistente.id_produto === id);
    return produtoExiste?.quantidade
  }

  enviarPedido(obs: string): boolean {
    const pedido:PedidoModel = {
      id_loja: Number(this.produtos[0].idLoja),
      itemPedido: this.produtos,
      obs: obs
    }
    this.crudService.postGenerico<any>('pedido', pedido).subscribe((res) => console.log(res) );
    console.log("Enviou pedido!")
    return true;
  }
}
