import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

import { LojaService } from '../services/loja.service';
import { LojaModel } from '../viewModel/loja.view-model';

@Component({
  selector: 'f-admin-loja',
  templateUrl: './admin-loja.component.html',
  styleUrls: ['./admin-loja.component.css']
})
export class AdminLojaComponent implements OnInit {

  loja = {
    nome: "",
    logo: "",
  } as LojaModel;

  editImg = false;

  constructor(
    private lojaService: LojaService,
  ) { }

  ngOnInit(): void {
    this.lojaService.get().subscribe(res => {
      if(res !== null)
        this.loja = res;
    });
  }

  save(form: NgForm) {

    if (this.loja.id !== undefined) {
      this.lojaService.update(this.loja).subscribe(() => {

      });
    } else {
      this.lojaService.save(this.loja).subscribe(() => {

      });
    }
  }

}
