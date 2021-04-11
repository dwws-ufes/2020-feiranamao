import { LojaModel } from "./loja.view-model";
import { CategoriaModel } from "./categoria.view-model";

export interface ProdutoModel {
  id: string;
  name: string;
  descricao: string;
  preco : number;
  custo : number;
	estoque : number;
  url? : string;
  categoria : CategoriaModel
  idLoja: LojaModel
}
