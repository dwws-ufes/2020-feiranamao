import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AccountService } from '../services/account.service';
import { UsuarioService } from '../services/usuario.service';
import { UsuarioModel } from '../viewModel/usuario.view-model';

@Component({
  selector: 'f-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  ehDono: boolean = false;
  ehAdmin: boolean = false;

  constructor(
    private router: Router,
    private accountService: AccountService,
    private usuarioService: UsuarioService
  ) { }

  ngOnInit(): void {
    this.usuarioService.getUsuario()
    .subscribe((r: UsuarioModel) => {
      // console.log(r)
      this.ehAdmin = r.login === "application-user";
      this.ehDono = r.dono;
    });
  }

  logout() {
    this.accountService.logout();
    this.router.navigate(['/login']);
  }

}
