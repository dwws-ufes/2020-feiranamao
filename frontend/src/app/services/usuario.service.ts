import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CrudService } from './crud.service';
import { UsuarioModel} from '../viewModel/usuario.view-model'
import { NgForm } from '@angular/forms';

@Injectable({
  providedIn: 'root'
  })
export class UsuarioService {
  usuarios: UsuarioModel[] | undefined;

  constructor(private crudService: CrudService) { }

  getUsuarios() {
    return this.crudService.getGenerico<UsuarioModel[]>('usuarios');
  }

  saveUsuario(usuario: UsuarioModel) {
     return this.crudService.postGenerico<UsuarioModel>('usuario',usuario);
    }

  deleteUsuario(id: string) {
    return this.crudService.deleteGenerico<UsuarioModel>('usuario',id);
  }

  updateUsuario(usuario: UsuarioModel) {
    return this.crudService.postGenerico<UsuarioModel>('usuario',usuario);
  }

}
