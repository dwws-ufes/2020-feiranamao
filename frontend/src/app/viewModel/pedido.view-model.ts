export interface PedidoItemModel {
  valorUnitario: number;
  quantidade: number;
  valorTotal: number;
  id_produto: string;
}

export interface PedidoModel {
  itemPedido: PedidoItemModel[];
  id_loja: number;
  obs: string;
}
