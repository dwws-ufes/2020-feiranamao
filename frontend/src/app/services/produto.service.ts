import { Injectable } from '@angular/core';
import { ProdutoModel } from '../viewModel/produtos.view-model';
import { CrudService } from './crud.service';

@Injectable({
  providedIn: 'root'
})
export class ProdutoService {
  isUserLoggedIn: any;
  username: any;
  token: any;
  produtos: ProdutoModel[] | undefined;

  constructor(private crudService: CrudService) { }

  getProdutos() {
    return this.crudService.getGenerico<ProdutoModel[]>('produtos');
  }
  getProdutosLoja(lojaId: number) {
    return this.crudService.getGenerico<ProdutoModel[]>(`loja/${lojaId}/produtos`);
  }

  editProduto(produto: ProdutoModel) {
    //return null;
  }
  deleteProduto(produto: ProdutoModel) {
    //return null;
}

}
