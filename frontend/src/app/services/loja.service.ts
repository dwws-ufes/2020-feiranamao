import { Injectable } from '@angular/core';
import { CrudService } from './crud.service';
import { LojaModel } from '../viewModel/loja.view-model';

@Injectable({providedIn: 'root'})
export class LojaService {

  constructor(private crudService: CrudService) { }

  usuarios: LojaModel[] | undefined;

  get() {
    return this.crudService.getGenerico<LojaModel>('loja');
  }

  getAll() {
    return this.crudService.getGenerico<LojaModel[]>('lojas');
  }

  save(p: LojaModel) {
     return this.crudService.postGenerico<LojaModel>('loja',p);
  }

  update(p: LojaModel) {
    return this.crudService.postGenerico<LojaModel>('loja',p);
  }

}
