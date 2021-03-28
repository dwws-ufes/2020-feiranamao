export interface ProdutoModel {
  id: string | undefined;
  name: string| undefined;
  descricao: string | undefined;
  preco? : number;
  custo? : number;
	estoque? : number;
  idCategoria? : string
}
