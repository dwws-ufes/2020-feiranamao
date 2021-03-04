package br.com.feiranamao.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.feiranamao.repository.ProdutoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import online.feiranamao.core.domain.Produto;

@Api(value="API Feira Na Mão")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/api")
public class FeiraNaMaoResource  {

	
	@Autowired
	ProdutoRepository produtoRepository;
	
	
    @ApiOperation(value=" Post Produto")
	@PostMapping("/produto")
	public Produto savePoint(@RequestBody Produto produto) throws Exception {
		
		return produtoRepository.save(produto);
	}
	

	
}