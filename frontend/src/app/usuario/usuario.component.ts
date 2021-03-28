import { Component, OnInit } from '@angular/core';
import { AccountService } from '../login/account.service';
import { UsuarioService } from '../services/usuario.service'
import { UsuarioModel } from '../viewModel/usuario.view-model';
import { NgForm, FormsModule, ReactiveFormsModule  } from '@angular/forms';

@Component({
  selector: 'app-usuario',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.scss']
})
export class UsuarioComponent implements OnInit {
  usuarios: UsuarioModel[] | undefined;
  usuario = {} as UsuarioModel;

  constructor(
    private accountService: AccountService,
    private usuarioService: UsuarioService,
  ) { }

  ngOnInit(): void {

    this.getUsuarios();
  }
   saveUsuario(form: NgForm) {
    if (this.usuario.id !== undefined) {
      this.usuarioService.updateUsuario(this.usuario).subscribe(() => {
        this.cleanForm(form);
      });
    } else {
      this.usuarioService.saveUsuario(this.usuario).subscribe(() => {
        this.cleanForm(form);
      });
    }
  }

  getUsuarios() {
    this.usuarioService.getUsuarios().subscribe(res => {
      this.usuarios = res;
      console.log(res);
    });
  }
  deleteUsuario(usuario: UsuarioModel) {
    this.usuarioService.deleteUsuario(usuario).subscribe(() => {
      this.getUsuarios();
    });
  }

  editUsuario(usuario: UsuarioModel) {
    this.usuario = { ...usuario };
  }

  // limpa o formulario
  cleanForm(form: NgForm) {
    this.getUsuarios();
    form.resetForm();
    this.usuario = {} as UsuarioModel;
  }

}
