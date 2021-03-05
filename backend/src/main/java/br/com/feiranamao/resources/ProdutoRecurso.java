package br.com.feiranamao.resources;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.feiranamao.model.Pedido;
import br.com.feiranamao.model.Produto;
import br.com.feiranamao.repository.ItemPedidoRepository;
import br.com.feiranamao.repository.PedidosRepository;
import br.com.feiranamao.repository.ProdutosRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="Feira Na Mão")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
//@RequestMapping(value = "/api")
public class ProdutoRecurso  {

	@Autowired
	ProdutosRepository produtosRepository;
	
	@ApiOperation(value=" Retorna Lista de Produtos")
	@GetMapping("/produtos")
	public List<Produto> listaProdutos(){
		
		return produtosRepository.findAll();
	}
	
	@ApiOperation(value="Procurar produtos por nome")
    @RequestMapping(value = "produtos/{nome}", method = RequestMethod.GET)
	public List<Produto> findByName(@PathVariable(value = "nome") String nome) {
		return produtosRepository.findByName(nome);
	}
	
    @ApiOperation(value=" Salvar Produto")
	@PostMapping("/produto")
	public Produto salvarProduto(@RequestBody Produto produto) throws Exception {
		return produtosRepository.save(produto);
	}
	
    @ApiOperation(value="Apagar produto")
	@DeleteMapping("/produto")
	public void deletePoints(@RequestBody Produto produto) {
    	produtosRepository.delete(produto);
		
	}
	
    @ApiOperation(value="Atualizar Produto")
	@PutMapping("/produto")
	public Produto updatePoints(@RequestBody Produto produto) {
		return produtosRepository.save(produto);
	}
    
	
}
