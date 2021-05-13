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
dbp:fat ?gordura .
FILTER (langMatches(lang(?descricao),"PT"))
}`;

    let params = new HttpParams()
      // .set('default-graph-uri', 'http://pt.dbpedia.org/resources')
      // .set('format', 'application/sparql-results+json')
      .set('query', query)
      .set('timeout', '30000');

    return this.http.get(endpointUrl, { params });
  }
}
