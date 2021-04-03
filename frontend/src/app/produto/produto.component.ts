import { Component, OnInit } from '@angular/core';
import { AccountService } from '../services/account.service';
import { ProdutoModel } from '../viewModel/produtos.view-model';
import { ProdutoService } from '../services/produto.service';
import { ActivatedRoute } from '@angular/router';
import { LojaModel } from '../viewModel/loja.view-model';
import { mergeMap, map } from 'rxjs/operators';

@Component({
  selector: 'f-produto',
  templateUrl: './produto.component.html',
  styleUrls: ['./produto.component.scss']
})
export class ProdutoComponent implements OnInit {

  produtos: ProdutoModel[] | undefined = [];
  loja: LojaModel | undefined;

  constructor(
    private produtoService: ProdutoService,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.route.params.pipe(
      mergeMap( ({ id }, _) => {
        return this.produtoService.getProdutosLoja(id).pipe(
          map(produtos => {
            this.produtos = produtos
            this.loja = produtos[0].idLoja;
          })
        );
      })
    ).subscribe();

  }
  editProduto(produto: ProdutoModel) {
    //return null;
  }
  deleteProduto(produto: ProdutoModel) {
    //return null;
}
}
