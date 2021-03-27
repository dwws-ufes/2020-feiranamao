import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ProdutoModel } from '../viewModel/produtos.view-model';
import { AccountService } from '../login/account.service';

@Injectable({
  providedIn: 'root'
})
export class ProdutoService {
  isUserLoggedIn: any;
  username: any;
  token: any;
  produtos: ProdutoModel[] | undefined;
  urlBase = 'localhost:8380';

  constructor(
    private accountService: AccountService,
    private httpClient: HttpClient
    ) { }


  getProdutos() {

    return this.httpClient.get<ProdutoModel[]>(
      'http://localhost:4200/produtos'
    ,{ headers: { authorization: 'Bearer '+ this.accountService.getToken() } })
  }

  editProduto(produto: ProdutoModel) {
    //return null;
  }
  deleteProduto(produto: ProdutoModel) {
    //return null;
}

}
