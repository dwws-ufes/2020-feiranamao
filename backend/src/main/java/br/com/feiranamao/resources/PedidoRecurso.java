package br.com.feiranamao.resources;

import java.util.List;
import java.util.Set;

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

import br.com.feiranamao.model.ItemPedido;
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
public class PedidoRecurso  {

	@Autowired
	PedidosRepository pedidosRepository;
	
	@ApiOperation(value=" Retorna Lista de Pedidos")
	@GetMapping("/pedidos")
	public List<Pedido> listaPedidos(){
		List<Pedido> pedidos= pedidosRepository.findAll();
		return  pedidos;
	}
	
    @ApiOperation(value=" Salvar Pedido")
	@PostMapping("/pedido")
	public Pedido salvarPedido(@RequestBody Pedido pedido) throws Exception {
    	
    	Set<ItemPedido> itens = pedido.getItemPedido();
    	
    	for(ItemPedido item : itens) {
    		item.setValorTotal(item.getValorUnitario()*item.getQuantidade());
    		
    	}
    	
     	return pedidosRepository.save(pedido);
	}	
}
