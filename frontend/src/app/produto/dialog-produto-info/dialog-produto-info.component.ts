import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';

export type DialogData = {
  nome: string;
  gordura: number;
  descricao: string;
  proteina: number;
} | null | undefined

@Component({
  selector: 'f-dialog-produto-info',
  templateUrl: './dialog-produto-info.component.html',
  styleUrls: ['./dialog-produto-info.component.scss']
})
export class DialogProdutoInfoComponent implements OnInit {

  constructor(@Inject(MAT_DIALOG_DATA) public data: DialogData) {}

  ngOnInit(): void {}

}
