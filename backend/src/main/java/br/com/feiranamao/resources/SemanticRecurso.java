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
import br.com.feiranamao.repository.LojasRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import reactor.netty.http.server.HttpServerRequest;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
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
	
	@Autowired
	LojasRepository lojaRepository;
	 
	@ApiOperation(value="Procurar produtos por nome")
    @RequestMapping(value = "/resources/products/{id}", method = RequestMethod.GET)
	public void listaProdutoRDFpK(HttpServletResponse response, HttpServerRequest request, @PathVariable(value = "id") String id) throws IOException {
		
		System.out.println("Teste");
		System.out.println(id);
		//System.out.println(request.uri());
		//System.out.print(request.fullPath());
		
	Model model = ModelFactory.createDefaultModel();
	
	//Namesapaces
	String feiraNameSpace = "http://localhost:8380/resources/products/#";
	model.setNsPrefix("fei", feiraNameSpace);
	
	String dbpNameSpace = "https://dbpedia.org/resource/";		
	model.setNsPrefix("dbp", dbpNameSpace);
	
	String schNameSpace = "https://schema.org/";		
	model.setNsPrefix("sch", schNameSpace);
	
	//Classes do vocabulario
	Resource productClass = ResourceFactory.createResource(schNameSpace+"Product");
	Resource foodClass = ResourceFactory.createResource(dbpNameSpace+"Food");
	Resource feiraProductClass = ResourceFactory.createResource(feiraNameSpace+"Product");
		
	//Propriedades
	Property propertyPrice = ResourceFactory.createProperty(feiraNameSpace+"price");
			
			
	List<Produto> produtos = produtosRepository.findByName(id);
	
	for (Produto produto : produtos) {
		model.createResource(feiraNameSpace+removerAcentos(produto.getName()))			
		.addProperty(propertyPrice, String.valueOf(produto.getPreco()))			
		.addProperty(RDFS.comment, produto.getDescricao())
		.addProperty(RDFS.label, produto.getName())			
		.addProperty(RDF.type, foodClass)
		.addProperty(RDF.type, productClass)
		.addProperty(RDF.type, feiraProductClass)
		;
		
	}
	 
	    
	response.setContentType("text/xml");
	
    try (PrintWriter out = response.getWriter()){
    	model.write(out, "RDF/XML");
    }
	} 
	@ApiOperation(value=" Retorna Lista de Produtos em RDF")
	@GetMapping("/resources/")
	@ResponseBody
	public void listaProdutoRDF(HttpServletResponse response, HttpServerRequest request) throws ServletException, IOException {
					
			System.out.print("Teste");
			System.out.print(response);
			//System.out.print(request.fullPath());
			
		Model model = ModelFactory.createDefaultModel();
		
		//Namesapaces
		String feiraNameSpace = "http://localhost:8380/resources/#";
		model.setNsPrefix("fei", feiraNameSpace);
		
		String dbpNameSpace = "https://dbpedia.org/resource/";		
		model.setNsPrefix("dbp", dbpNameSpace);
		
		String schNameSpace = "https://schema.org/";		
		model.setNsPrefix("sch", schNameSpace);
		
		//Classes do vocabulario
		Resource productClass = ResourceFactory.createResource(schNameSpace+"Product");
		Resource foodClass = ResourceFactory.createResource(dbpNameSpace+"Food");
		Resource feiraProductClass = ResourceFactory.createResource(feiraNameSpace+"Product");
			
		//Propriedades
		Property propertyPrice = ResourceFactory.createProperty(feiraNameSpace+"price");
				
		List<Produto> produtos = produtosRepository.findAll();
				
		for (Produto produto : produtos) {
			model.createResource(feiraNameSpace+removerAcentos(produto.getName()))			
			.addProperty(propertyPrice, String.valueOf(produto.getPreco()))			
			.addProperty(RDFS.comment, produto.getDescricao())
			.addProperty(RDFS.label, produto.getName())			
			.addProperty(RDF.type, foodClass)
			.addProperty(RDF.type, productClass)
			.addProperty(RDF.type, feiraProductClass)
			;
		} 
		    
		response.setContentType("text/xml");
		
	    try (PrintWriter out = response.getWriter()){
	    	model.write(out, "RDF/XML");
	    }
	}
	
	
	@ApiOperation(value=" Retorna Lista de Produtos em RDF")
	@GetMapping("/resources/{param}")
	@ResponseBody
	public void listaProdutoRDF(HttpServletResponse response, HttpServletRequest request, @PathVariable(value = "param") String param) throws ServletException, IOException {
		Model model = ModelFactory.createDefaultModel();
		
		//Namesapaces
		String feiraNameSpace = "http://localhost:8380/resources/products/#";
		model.setNsPrefix("fei", feiraNameSpace);
		
		String dbpNameSpace = "https://dbpedia.org/resource/";		
		model.setNsPrefix("dbp", dbpNameSpace);
		
		String schNameSpace = "https://schema.org/";		
		model.setNsPrefix("sch", schNameSpace);
		
		//Classes do vocabulario
		Resource productClass = ResourceFactory.createResource(schNameSpace+"Product");
		Resource foodClass = ResourceFactory.createResource(dbpNameSpace+"Food");
		Resource feiraProductClass = ResourceFactory.createResource(feiraNameSpace+"Product");
			
		//Propriedades
		Property propertyPrice = ResourceFactory.createProperty(feiraNameSpace+"price");
				
		List<Produto> produtos = produtosRepository.findAll();
				
		for (Produto produto : produtos) {
			//if(produto.getName().equals(@PathVariable(value="someID")))
			model.createResource(feiraNameSpace+removerAcentos(produto.getName()))			
			.addProperty(propertyPrice, String.valueOf(produto.getPreco()))			
			.addProperty(RDFS.comment, produto.getDescricao())
			.addProperty(RDFS.label, produto.getName())			
			.addProperty(RDF.type, foodClass)
			.addProperty(RDF.type, productClass)
			.addProperty(RDF.type, feiraProductClass)
			;
		} 
		
		model.createResource(feiraNameSpace+"Pera")			
		.addProperty(propertyPrice, "1")			
		.addProperty(RDFS.comment, "Pera")
		.addProperty(RDFS.label, "Pera")			
		.addProperty(RDF.type, foodClass)
		.addProperty(RDF.type, productClass)
		.addProperty(RDF.type, feiraProductClass)
		;
		
		model.createResource(feiraNameSpace+"Uva")			
		.addProperty(propertyPrice, "1")			
		.addProperty(RDFS.comment, "Uva")
		.addProperty(RDFS.label, "Uva")			
		.addProperty(RDF.type, foodClass)
		.addProperty(RDF.type, productClass)
		.addProperty(RDF.type, feiraProductClass)
		;
		
		model.createResource(feiraNameSpace+"Maça")			
		.addProperty(propertyPrice, "1")			
		.addProperty(RDFS.comment, "Maça")
		.addProperty(RDFS.label, "Maça")			
		.addProperty(RDF.type, foodClass)
		.addProperty(RDF.type, productClass)
		.addProperty(RDF.type, feiraProductClass)
		;
		
		model.createResource(feiraNameSpace+"SaladaMista")			
		.addProperty(propertyPrice, "1")			
		.addProperty(RDFS.comment, "SaladaMista")
		.addProperty(RDFS.label, "SaladaMista")			
		.addProperty(RDF.type, foodClass)
		.addProperty(RDF.type, productClass)
		.addProperty(RDF.type, feiraProductClass)
		;
		    
		response.setContentType("text/xml");
		
	    try (PrintWriter out = response.getWriter()){
	    	model.write(out, "RDF/XML");
	    }
	}
	
	
	public static String removerAcentos(String str) {
	    return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "").replace(" ", "-");
	}
	
	
}
