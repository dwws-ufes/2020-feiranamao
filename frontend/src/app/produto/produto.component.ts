import { Component, OnInit } from '@angular/core';
import { AccountService } from '../services/account.service';
import { ProdutoModel } from '../viewModel/produtos.view-model';
import { ProdutoService } from '../services/produto.service';
import { ActivatedRoute } from '@angular/router';
import { LojaModel } from '../viewModel/loja.view-model';
import { mergeMap, map } from 'rxjs/operators';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'f-produto',
  templateUrl: './produto.component.html',
  styleUrls: ['./produto.component.scss']
})
export class ProdutoComponent implements OnInit {

  produtos: ProdutoModel[] = new Array<ProdutoModel>();
  loja: LojaModel | undefined;

  constructor(
    private produtoService: ProdutoService,
    private route: ActivatedRoute,
    private _snackBar: MatSnackBar
  ) { }

  ngOnInit(): void {
    this.route.params.pipe(
      mergeMap( ({ id }, _) => {
        return this.produtoService.getProdutosLoja(id).pipe(
          map(produtos => {
            if (produtos.length !== 0) {
              this.produtos = produtos
              this.loja = produtos[0].idLoja;
            }
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

  openSnackBar(message: string, action: string) {
    this._snackBar.open(message, action, {
      duration: 2000,
    });
  }
}
