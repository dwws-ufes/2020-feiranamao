import { LojaModel } from "./loja.view-model";

export interface ProdutoModel {
  id: string;
  name: string;
  descricao: string;
  preco : number;
  custo : number;
	estoque : number;
  idCategoria? : string
  idLoja: LojaModel
}
