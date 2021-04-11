import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

import { ProdutoService } from '../services/produto.service';
import { ProdutoModel } from '../viewModel/produtos.view-model';

@Component({
  selector: 'f-admin-produto',
  templateUrl: './admin-produto.component.html',
  styleUrls: ['./admin-produto.component.css']
})
export class AdminProdutoComponent implements OnInit {

  produtos: ProdutoModel[] | undefined;
  produto = {} as ProdutoModel;
  categorias = [{id: 1, name: "Folha"}, {id: 2, name: "Legume"}]

  constructor(private produtoService: ProdutoService) { }

  ngOnInit(): void {
    this.get();
    this.getCategorias();
  }

  save(form: NgForm) {

    if (this.produto.id !== undefined) {
      this.produtoService.updateProduto(this.produto).subscribe(() => {
        this.cleanForm(form);
        this.get();
      });
    } else {
      this.produtoService.saveProduto(this.produto).subscribe(() => {
        this.cleanForm(form);
        this.get();
      });
    }
  }

  get() {
    this.produtoService.getProdutos().subscribe(res => {
      this.produtos = res;
    });
  }
  getCategorias() {
    this.produtoService.getCategorias().subscribe(res => {
      console.log(this.categorias)
      console.log(res)
      this.categorias = res;
    });
  }
  delete(produto: ProdutoModel) {
    this.produtoService.deleteProduto(String(produto.id)).subscribe(() => {
      this.get();
    });
  }

  edit(produto: ProdutoModel) {
    this.produto = { ...produto };
    console.log(this.produto);
    //this.produto.senha = '';
    this.produto.categoria = produto.categoria
  }

  cleanForm(form: NgForm) {
    //this.getUsuarios();
    form.resetForm();
    this.produto = {} as ProdutoModel;
  }

}
