package br.com.feiranamao.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.feiranamao.model.Loja;
import br.com.feiranamao.model.Produto;
import br.com.feiranamao.model.Usuario;
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
 
	@ApiOperation(value=" Retorna dados da loja do usuario logado")
	@GetMapping("/loja") 
	public Loja retornaLoja(@AuthenticationPrincipal final Usuario user){
//		System.out.println(user.getId());
		return lojasRepository.findByUsuario(user);
	}

    @ApiOperation(value="Atualizar loja")
	@PutMapping("/loja")
	public Loja atualizarLoja(@RequestBody Loja loja, @AuthenticationPrincipal final Usuario user) {

    	loja.setUsuario(user);    	
    	
		return lojasRepository.save(loja);
	}

	@ApiOperation(value="Listar lojas")
	@GetMapping("/lojas")
	public List<Loja> listaLojas() {
		return lojasRepository.findAll();
	}

	@ApiOperation(value="Listar produtos da loja")
	@GetMapping("/loja/{id}/produtos")//TODO Tratamento de erro not found
	public List<Produto> listaItemLoja(@PathVariable(value = "id") Long id) {
		return produtosRepository.findByLoja(lojasRepository.findById(id));
	}
	
    @ApiOperation(value=" Salvar Loja")
	@PostMapping("/loja")
	public Loja salvarLoja(@RequestBody Loja loja, @AuthenticationPrincipal final Usuario user) throws Exception {
    	
    	loja.setUsuario(user);
    	
		return lojasRepository.save(loja);
	}    
    
}
