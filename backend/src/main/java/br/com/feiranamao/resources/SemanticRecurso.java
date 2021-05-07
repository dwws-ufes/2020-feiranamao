package br.com.feiranamao.resources;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.Normalizer;
import java.util.List;

import javax.servlet.ServletException;
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
import br.com.feiranamao.model.Produto;
import br.com.feiranamao.model.Usuario;
import br.com.feiranamao.repository.ProdutosRepository;
import br.com.feiranamao.repository.LojasRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
	    
	@ApiOperation(value=" Retorna Lista de Produtos em RDF")
	@GetMapping("/resources/produtos")
	@ResponseBody
	public void listaProdutosRDF(HttpServletResponse response) throws ServletException, IOException {
				
		Model model = ModelFactory.createDefaultModel();
		
		//Namesapaces
		String feiraNameSpace = "http://localhost/resources/Produto";
		
		//Classes do vocabulario
		Resource resourceX = ResourceFactory.createResource(feiraNameSpace+"X");
			
		//Propriedades
		Property propertyPreco = ResourceFactory.createProperty(feiraNameSpace+"/Preco");
		
		List<Produto> produtos = produtosRepository.findAll();
				
		for (Produto produto : produtos) {
			model.createResource(feiraNameSpace+"/"+removerAcentos(produto.getName()))
			//.addProperty(RDF.type, resourceX)
			.addProperty(RDFS.label, produto.getName())
			.addProperty(RDFS.comment, produto.getDescricao())
			.addProperty(propertyPreco, String.valueOf(produto.getPreco()));
		} 
		    
	    try (PrintWriter out = response.getWriter()){
	    	model.write(out, "RDF/XML");
	    }
	}
    
	public static String removerAcentos(String str) {
	    return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "").replace(" ", "-");
	}
	
	
}
