import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { HomeComponent } from './home/home.component';
import { ProdutoComponent } from './produto/produto.component';
import { LojasComponent } from './lojas/lojas.component';
import { LoginComponent } from './login/login.component';
import { DefaultComponent } from './default/default.component';
import { UsuarioComponent } from './usuario/usuario.component';
import { ProdutoItemComponent } from './produto/produto-item/produto-item.component';
import { MatIconModule } from '@angular/material/icon';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CartComponent } from './cart/cart.component';
import { AdminLojaComponent } from './admin-loja/admin-loja.component';
import { AdminProdutoComponent } from './admin-produto/admin-produto.component';
import { CartItemComponent } from './cart/cart-item/cart-item.component';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { SuccessComponent } from './success/success.component';
import { DialogProdutoInfoComponent } from './produto/dialog-produto-info/dialog-produto-info.component';
import { MatDialogModule } from '@angular/material/dialog';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    HomeComponent,
    ProdutoComponent,
    LoginComponent,
    LojasComponent,
    DefaultComponent,
    UsuarioComponent,
    ProdutoItemComponent,
    CartComponent,
    AdminLojaComponent,
    AdminProdutoComponent,
    CartItemComponent,
    SuccessComponent,
    DialogProdutoInfoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    MatIconModule,
    BrowserAnimationsModule,
    MatSnackBarModule,
    MatDialogModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
