package br.com.feiranamao.resources;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.feiranamao.model.Produto;
import br.com.feiranamao.repository.ProdutosRepository;
import br.com.feiranamao.repository.ReferencesRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="Feira Na Mão")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/api")
public class ProdutosResource  {

	@Autowired
	ProdutosRepository produtosRepository;
	
	@ApiOperation(value=" Return List Points")
	@GetMapping("/points")
	public List<Produto> listPoints(){
		
		return produtosRepository.findAll();
	}
	
	@ApiOperation(value="Find Produtos By Name")
    @RequestMapping(value = "produtos/{name}", method = RequestMethod.GET)
	public List<Produto> findByName(@PathVariable(value = "name") String name) {
		return produtosRepository.findByName(name);
	}
	
    @ApiOperation(value=" Post Produtos")
	@PostMapping("/produtos")
	public Produto savePoint(@RequestBody Produto produto) throws Exception {
		return produtosRepository.save(produto);
	}
	
    @ApiOperation(value="Delete Produtos")
	@DeleteMapping("/points")
	public void deletePoints(@RequestBody Produto produto) {
    	produtosRepository.delete(produto);
		
	}
	
    @ApiOperation(value="Update Produtos")
	@PutMapping("/produtos")
	public Produto updatePoints(@RequestBody Produto produto) {
		return produtosRepository.save(produto);
	}
    
	
}
