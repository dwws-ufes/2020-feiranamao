package br.com.feiranamao.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.feiranamao.model.Loja;
import br.com.feiranamao.repository.LojasRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="Feira Na Mão")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LojaRecurso  {

	@Autowired
	LojasRepository lojasRepository;
	
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
	
}
