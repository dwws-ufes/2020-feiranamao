import { Component, OnInit } from '@angular/core';
import { AccountService } from '../login/account.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { ProdutosModelViewModel } from '../viewModel/produtos.view-model';

@Component({
  selector: 'f-perfil',
  templateUrl: './perfil.component.html',
  styleUrls: ['./perfil.component.scss']
})
export class PerfilComponent implements OnInit {

  isUserLoggedIn: any;
  username: any;
  token: any;
  produtos: ProdutosModelViewModel[] | undefined;

  constructor(
    private accountService: AccountService,
    private httpClient: HttpClient,

  ) { }

  ngOnInit(): void {
    this.isUserLoggedIn = this.accountService.isUserLoggedIn()?'Logado':'Deslogado';
    this.username = this.accountService.getUserLoggedIn();
    this.token = this.accountService.getToken();

    this.getProdutos();
  }

  getProdutos() {
    return this.httpClient.get<ProdutosModelViewModel[]>('http://localhost:4200/produtos'
    ,{ headers: { authorization: 'Bearer '+ this.token } })
    .subscribe((res: ProdutosModelViewModel[]) => {
      this.produtos = res;
    });
    ;
  }

}
