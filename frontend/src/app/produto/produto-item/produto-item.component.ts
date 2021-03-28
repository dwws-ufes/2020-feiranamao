import { Component, Input, OnInit } from '@angular/core';
import { ProdutoModel } from 'src/app/viewModel/produtos.view-model';

@Component({
  selector: 'f-produto-item',
  templateUrl: './produto-item.component.html',
  styleUrls: ['./produto-item.component.scss']
})
export class ProdutoItemComponent implements OnInit {

  @Input() produto: ProdutoModel|undefined = undefined;

  constructor() { }

  ngOnInit(): void {
  }

}
