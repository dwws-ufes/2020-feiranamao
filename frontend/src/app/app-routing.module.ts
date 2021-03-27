import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserGuard } from './guards/user.guard';
import { HomeComponent } from './home/home.component';
import { LojasComponent } from './lojas/lojas.component';
import { ProdutoComponent } from './produto/produto.component';
import { LoginComponent } from './login/login.component';
import { DefaultComponent } from './default/default.component';

const routes: Routes = [
  { path: '', component: DefaultComponent, canActivate: [UserGuard],
    children: [
      { path: 'home', component: HomeComponent },
      { path: 'produto', component: ProdutoComponent },
      { path: 'lojas', component: LojasComponent },
    ]
  },
  { path: 'login', component: LoginComponent },
  { path: '**', redirectTo: '' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
