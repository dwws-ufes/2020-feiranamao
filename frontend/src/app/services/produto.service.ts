import { Injectable } from '@angular/core';
import { CategoriaModel } from '../viewModel/categoria.view-model';
import { ProdutoModel } from '../viewModel/produtos.view-model';
import { CrudService } from './crud.service';

@Injectable({
  providedIn: 'root'
})
export class ProdutoService {
  isUserLoggedIn: any;
  username: any;
  token: any;

  constructor(private crudService: CrudService) { }

  getProdutos() {
    return this.crudService.getGenerico<ProdutoModel[]>('produtos');
  }

  getCategorias() {
    return this.crudService.getGenerico<CategoriaModel[]>('categorias');
  }

  getProdutosLoja(lojaId: number) {
    return this.crudService.getGenerico<ProdutoModel[]>(`loja/${lojaId}/produtos`);
  }

  saveProduto(produto: ProdutoModel) {
    let p = JSON.parse(JSON.stringify(produto));
    const { id } = produto.categoria;
    p.categoria = { id };
    return this.crudService.postGenerico<ProdutoModel>('produto',p);
  }

  deleteProduto(id: string) {
      return this.crudService.deleteGenerico<ProdutoModel>('produto',id);
  }

  updateProduto(produto: ProdutoModel) {
    let p = JSON.parse(JSON.stringify(produto));
    p.categoria = {id:produto.categoria}
    return this.crudService.postGenerico<ProdutoModel>('produto',p);
  }
}
