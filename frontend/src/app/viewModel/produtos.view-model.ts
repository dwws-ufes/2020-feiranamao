export class ProdutosModelViewModel {
  id: string | undefined;
  name: string| undefined;
  descricao: string | undefined;

  constructor(u: any) {
      this.id = u.id != undefined ? u.id : null;
      this.name = u.name != null ? u.name : null;
      this.descricao = u.descricao != null ? u.descricao : null;
    }
}
