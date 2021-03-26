export class ProdutoSave {
    codProd: number;
    qtdNeg: number;


    constructor(p: any) {
        this.codProd = p.codProd !== null ? p.codProd : null;
        this.qtdNeg = p.valor !== null ? p.valor : null;
    }
}
