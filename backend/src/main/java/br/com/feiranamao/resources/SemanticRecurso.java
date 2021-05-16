package br.com.feiranamao.resources;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.Normalizer;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import br.com.feiranamao.model.Produto;
import br.com.feiranamao.model.Usuario;
import br.com.feiranamao.repository.ProdutosRepository;
import br.com.feiranamao.repository.CategoriasRepository;
import br.com.feiranamao.repository.LojasRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import reactor.netty.http.server.HttpServerRequest;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.ResourceFactory;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.RDFS;

@Api(value="Feira Na Mão")
@CrossOrigin(origins = "http://localhost:4200")
@Controller
public class SemanticRecurso  {

	@Autowired
	ProdutosRepository produtosRepository;
	
	static String feiraNameSpace = "http://localhost:8380/resources/products/";
	static String dbpNameSpace = "https://dbpedia.org/resource/";
	static String schNameSpace = "https://schema.org/";		
	
	@Autowired
	LojasRepository lojaRepository;
	 
	@ApiOperation(value="Procurar produtos por nome")
    @RequestMapping(value = "/resources/products/{nome}", method = RequestMethod.GET)
	public void listaProdutoRDFpK(HttpServletResponse response, HttpServerRequest request, @PathVariable(value = "nome") String nome) throws IOException {
		
		Model model = createJenaModel();
				
		List<Produto> produtos = produtosRepository.findByName(nome);
		
		for (Produto produto : produtos) {
			addProdutoModel(model, produto);			
		}
		 		    
		response.setContentType("text/xml");
		
	    try (PrintWriter out = response.getWriter()){
	    	model.write(out, "RDF/XML");
	    }
	} 
	
	@ApiOperation(value=" Retorna Lista de Produtos em RDF")
	@GetMapping("/resources/products")
	@ResponseBody
	public void listaProdutoRDF(HttpServletResponse response, HttpServerRequest request) throws ServletException, IOException {
			
		Model model = createJenaModel();
				
		List<Produto> produtos = produtosRepository.findAll();
				
		for (Produto produto : produtos) {
			addProdutoModel(model, produto);
		} 
		    
		response.setContentType("text/xml");
		
	    try (PrintWriter out = response.getWriter()){
	    	model.write(out, "RDF/XML");
	    }
	}
	
	public static Model createJenaModel() {
		Model model = ModelFactory.createDefaultModel();
		
		//Namesapaces
		model.setNsPrefix("fei", feiraNameSpace);
		model.setNsPrefix("dbp", dbpNameSpace);	
		model.setNsPrefix("sch", schNameSpace);
		
		return model;
	}
	
	public static void addProdutoModel(Model model, Produto produto) {
		model.createResource(feiraNameSpace+removerAcentos(produto.getName()))			
			.addProperty(ResourceFactory.createProperty(dbpNameSpace+"price"), String.valueOf(produto.getPreco()))
			.addProperty(ResourceFactory.createProperty(schNameSpace+"category"), produto.getCategoria().getName())
			.addProperty(ResourceFactory.createProperty(schNameSpace+"image"), produto.getUrl())
			.addProperty(RDFS.comment, produto.getDescricao())
			.addProperty(RDFS.label, produto.getName())
			.addProperty(RDF.type, ResourceFactory.createResource(dbpNameSpace+"Food"))
			.addProperty(RDF.type, ResourceFactory.createResource(schNameSpace+"Product"))
			.addProperty(RDF.type, ResourceFactory.createResource(feiraNameSpace+"Product"))
		;
	}
	
	public static String removerAcentos(String str) {
	    return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "").replace(" ", "-");
	}
	
	
}
