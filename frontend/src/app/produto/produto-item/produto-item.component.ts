import { Component, Input, OnInit } from '@angular/core';
import { CarrinhoService } from 'src/app/services/carrinho.service';
import { ProdutoModel } from 'src/app/viewModel/produtos.view-model';
import { DialogData, DialogProdutoInfoComponent } from '../dialog-produto-info/dialog-produto-info.component';
import { MatDialog } from '@angular/material/dialog';
import { SparqlService } from 'src/app/services/sparql.service';

@Component({
  selector: 'f-produto-item',
  templateUrl: './produto-item.component.html',
  styleUrls: ['./produto-item.component.scss']
})
export class ProdutoItemComponent implements OnInit {

  @Input() produto!: ProdutoModel;
  contador: number = 0;
  isTooltipOpen: boolean = false;

  sparqlData: DialogData = null;

  constructor(private carrinhoService: CarrinhoService, public dialog: MatDialog, private sparqlService: SparqlService) { }

  ngOnInit(): void {
    this.contador = this.carrinhoService.quantidadeItem(this.produto.id);
    this.sparqlService.getSparqlProduto(this.produto.name).subscribe({
      next: (data: any) => {
        if (data.results.bindings.length !== 0) {
          const { gordura, descricao } = data.results.bindings[0];
          this.sparqlData = {
              nome: this.produto.name,
              gordura: gordura.value,
              descricao: descricao.value
          };
        } else {
          this.sparqlData = null;
        }
        }
      }
    );
  }

  openDialog() {
    this.dialog.open(DialogProdutoInfoComponent, {
      data: this.sparqlData
    });
  }

  adicionarAoCarrinho(produto: ProdutoModel) {
    this.carrinhoService.adicionaItemPedido(produto);
    this.contador = this.carrinhoService.quantidadeItem(produto.id);
  }

  removeDoCarrinho(produto: ProdutoModel) {
    this.carrinhoService.removeItemPedido(produto);
    this.contador = this.carrinhoService.quantidadeItem(produto.id);
  }

  existeNoCarrinho(produto: ProdutoModel) {
    return this.carrinhoService.quantidadeItem(produto.id) > 0;
  }
}
