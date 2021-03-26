export class ProdutoViewModel {
    codProd: string;
    codVol: string;
    codVolApr: string;
    complDesc: string;
    descCompl: string;
    descrProd: string;
    isPromocional: string;
    marca: string;
    pesoBruto: string;
    pesoLiq: string;
    unidade: string;
    valProd: string;
    valProdUnit: string;
    valor: number;
    quantidade: number;

    constructor(p: any) {
        this.codProd = p.codProd !== null ? p.codProd : null;
        this.codVol = p.codVol !== null ? p.codVol : null;
        this.codVolApr = p.codVolApr !== null ? p.codVolApr : null;
        this.complDesc = p.complDesc !== null ? p.complDesc : null;
        this.descCompl = p.descCompl !== null ? p.descCompl : null;
        this.descrProd = p.descrProd !== null ? p.descrProd : null;
        this.isPromocional = p.isPromocional !== null ? p.isPromocional : null;
        this.marca = p.marca !== null ? p.marca : null;
        this.pesoBruto = p.pesoBruto !== null ? p.pesoBruto : null;
        this.pesoLiq = p.pesoLiq !== null ? p.pesoLiq : null;
        this.unidade = p.unidade !== null ? p.unidade : null;
        this.valProd = p.valProd !== null ? p.valProd : null;
        this.valProdUnit = p.valProdUnit !== null ? p.valProdUnit : null;
        this.valor = p.valor !== null ? p.valor : null;
        this.quantidade = p.quantidade !== null ? p.quantidade : null;
    }
}
