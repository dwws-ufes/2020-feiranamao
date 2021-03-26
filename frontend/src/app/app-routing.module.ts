import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserGuardGuard } from './guards/user-guard.guard';
import { HomeComponent } from './home/home.component';
import { LojasComponent } from './lojas/lojas.component';
import { PerfilComponent } from './perfil/perfil.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent, canActivate: [UserGuardGuard] },
  { path: 'perfil', component: PerfilComponent },
  { path: 'lojas', component: LojasComponent },
  { path: 'login', component: LoginComponent },
  { path: '**', component: HomeComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
