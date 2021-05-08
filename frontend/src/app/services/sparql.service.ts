import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SparqlService {

  constructor(private http: HttpClient) { }

  getSparqlProduto(produto: string) {
    const endpointUrl = 'http://dbpedia.org/sparql';

    const query = `SELECT *
WHERE {
?uri rdfs:label "${produto}"@pt;
rdfs:comment ?descricao;
dbp:fat ?calorias .
FILTER (langMatches(lang(?descricao),"PT"))
}`;

    let params = new HttpParams()
      // .set('default-graph-uri', 'http://pt.dbpedia.org/resources')
      .set('query', query)
      .set('timeout', '30000');

    this.http.get(endpointUrl, { params })
      .subscribe((data: any) => {
        console.log(data.results.bindings);
      });
  }
}
