import { Component, OnInit } from '@angular/core';
import { AccountService } from '../login/account.service';
import { ProdutoModel } from '../viewModel/produtos.view-model';
import { ProdutoService } from '../services/produto.service';

@Component({
  selector: 'f-produto',
  templateUrl: './produto.component.html',
  styleUrls: ['./produto.component.scss']
})
export class ProdutoComponent implements OnInit {

  isUserLoggedIn: any;
  username: any;
  token: any;
  produtos: ProdutoModel[] | undefined = [
    { id: '1', name: 'banana', descricao: 'top d+',preco: 3},

  ];

  constructor(
    private accountService: AccountService,
    private produtoService: ProdutoService,
  ) { }

  ngOnInit(): void {
    this.isUserLoggedIn = this.accountService.isUserLoggedIn()?'Logado':'Deslogado';
    this.username = this.accountService.getUserLoggedIn();
    this.token = this.accountService.getToken();

    // this.produtoService.getProdutos().subscribe(res => {
    //   this.produtos = res;

    //   console.log(res);
    // });
  }
  editProduto(produto: ProdutoModel) {
    //return null;
  }
  deleteProduto(produto: ProdutoModel) {
    //return null;
}
}
