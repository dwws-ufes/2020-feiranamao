import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ProdutoModel } from '../viewModel/produtos.view-model';
import { AccountService } from '../login/account.service';
import { environment } from '../environments/environment.prod'

@Injectable({
  providedIn: 'root'
})
export class ProdutoService {
  isUserLoggedIn: any;
  username: any;
  token: any;
  produtos: ProdutoModel[] | undefined;

  constructor(
    private accountService: AccountService,
    private httpClient: HttpClient
    ) { }


  getProdutos() {
    return this.getGenerico<ProdutoModel>('produtos')
  }

  getGenerico<T>(endpoint: string, param?:string) {

    let url = environment.URL_API +"/" +endpoint;

    if(param) url +=  "/"+param;

    return this.httpClient.get<T[]>(
      url
    ,{ headers: { authorization: 'Bearer '+ this.accountService.getToken() } })
  }

  editProduto(produto: ProdutoModel) {
    //return null;
  }
  deleteProduto(produto: ProdutoModel) {
    //return null;
}

}
