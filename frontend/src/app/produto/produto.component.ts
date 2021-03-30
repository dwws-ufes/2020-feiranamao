import { Component, OnInit } from '@angular/core';
import { AccountService } from '../services/account.service';
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
  produtos: ProdutoModel[] | undefined = [];

  constructor(
    private produtoService: ProdutoService,
  ) { }

  ngOnInit(): void {
    this.produtoService.getProdutos().subscribe(res => {
      this.produtos = res;
    });
  }
  editProduto(produto: ProdutoModel) {
    //return null;
  }
  deleteProduto(produto: ProdutoModel) {
    //return null;
}
}
