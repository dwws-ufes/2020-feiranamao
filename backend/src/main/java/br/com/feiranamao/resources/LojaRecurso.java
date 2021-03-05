package br.com.feiranamao.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
import org.springframework.web.servlet.ModelAndView;

import br.com.feiranamao.model.ItemPedido;
import br.com.feiranamao.model.Loja;
import br.com.feiranamao.model.Pedido;
import br.com.feiranamao.model.Produto;
import br.com.feiranamao.repository.ItemPedidoRepository;
import br.com.feiranamao.repository.PedidosRepository;
import br.com.feiranamao.repository.ProdutosRepository;
import br.com.feiranamao.repository.LojaRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="Feira Na Mão")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
//@RequestMapping(value = "/api")
public class LojaRecurso  {

	@Autowired
	LojaRepository lojaRepository;
	
    @ApiOperation(value=" Salvar Pedido")
	@PostMapping("/loja")
	public Loja salvarPedido(@RequestBody Loja loja) throws Exception {

   	return lojaRepository.save(loja);
	}
	
    
	
}
