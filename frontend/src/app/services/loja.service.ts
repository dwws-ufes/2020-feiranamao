import { Injectable } from '@angular/core';
import { CrudService } from './crud.service';

import { LojaModel } from '../viewModel/loja.view-model';

@Injectable({
  providedIn: 'root'
  })
export class LojaService {
  usuarios: LojaModel[] | undefined;

  constructor(private crudService: CrudService) { }

  get() {
    return this.crudService.getGenerico<LojaModel>('loja');
  }

  save(p: LojaModel) {
     return this.crudService.postGenerico<LojaModel>('loja',p);
  }

  update(p: LojaModel) {
    return this.crudService.postGenerico<LojaModel>('loja',p);
  }

}
