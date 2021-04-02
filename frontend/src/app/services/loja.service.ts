import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CrudService } from './crud.service';
import { LojaModel } from '../viewModel/loja.view-model';

@Injectable({providedIn: 'root'})
export class LojaService {

  constructor(private crudService: CrudService) { }

  getLojas() {
    return this.crudService.getGenerico<LojaModel[]>('lojas');
  }

}
