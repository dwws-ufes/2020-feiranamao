import { Component, OnInit } from '@angular/core';
import { AccountService } from '../login/account.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { ProdutosModelViewModel } from '../viewModel/produtos.view-model';

@Component({
  selector: 'f-produto',
  templateUrl: './produto.component.html',
  styleUrls: ['./produto.component.scss']
})
export class ProdutoComponent implements OnInit {

  isUserLoggedIn: any;
  username: any;
  token: any;
  produtos: ProdutosModelViewModel[] | undefined;

  constructor(
    private accountService: AccountService,
    private httpClient: HttpClient,

  ) { }

  ngOnInit(): void {
    this.isUserLoggedIn = this.accountService.isUserLoggedIn()?'Logado':'Deslogado';
    this.username = this.accountService.getUserLoggedIn();
    this.token = this.accountService.getToken();

    this.getProdutos().subscribe((res: ProdutosModelViewModel[]) => {
      this.produtos = res;

      console.log(this.produtos );

    });;
  }

  getProdutos() {
    return this.httpClient.get<ProdutosModelViewModel[]>(
      'http://localhost:4200/produtos'
    ,{ headers: { authorization: 'Bearer '+ this.token } })
  }

  editProduto(produto: ProdutosModelViewModel) {
    //return null;
  }
  deleteProduto(produto: ProdutosModelViewModel) {
    //return null;
}
}
