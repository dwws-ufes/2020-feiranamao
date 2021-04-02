package br.com.feiranamao.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.feiranamao.model.Loja;
import br.com.feiranamao.model.Produto;
import br.com.feiranamao.repository.LojasRepository;
import br.com.feiranamao.repository.ProdutosRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="Feira Na Mão")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LojaRecurso  {

	@Autowired
	LojasRepository lojasRepository;
	
	@Autowired
	ProdutosRepository produtosRepository;

    @ApiOperation(value=" Salvar Pedido")
	@PostMapping("/loja")
	public Loja salvarPedido(@RequestBody Loja loja) throws Exception {

   	return lojasRepository.save(loja);
	}

    @ApiOperation(value="Atualizar loja")
	@PutMapping("/loja")
	public Loja atualizarLoja(@RequestBody Loja loja) {
		return lojasRepository.save(loja);
	}

	@ApiOperation(value="Listar lojas")
	@GetMapping("/lojas")
	public List<Loja> listaLojas() {
		return lojasRepository.findAll();
	}

	@ApiOperation(value="Listar produtos da loja")
	@GetMapping("/loja/{id}/produtos")
	public List<Produto> listaItemLoja(@PathVariable(value = "id") Long id) {
		return produtosRepository.findByLoja(lojasRepository.findById(id));
	}
	
}
