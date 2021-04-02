import { Component, OnInit } from '@angular/core';
import { LojaService } from '../services/loja.service';
import { PedidosService } from '../services/pedidos.service';
import { LojaModel } from '../viewModel/loja.view-model';

@Component({
  selector: 'f-lojas',
  templateUrl: './lojas.component.html',
  styleUrls: ['./lojas.component.scss']
})
//Lenke é bobão kkkk
export class LojasComponent implements OnInit {

  lojas = new Array<LojaModel>();

  constructor(private lojaService: LojaService) {}

  ngOnInit(): void {
    // this.lojaService.getLojas().subscribe(lojas => {
    //   this.lojas = lojas
    // })

    this.lojas = [
      { id_loja: 1, nome: 'Loja do Seu Zé' },
      { id_loja: 2, nome: 'Mercadinho Lindo' }
    ]
  }

}
