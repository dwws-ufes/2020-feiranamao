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
@RequestMapping(value = "/api")
public class ProdutosResource  {

	@Autowired
	ProdutosRepository produtosRepository;
	
	@Autowired
	PedidosRepository pedidosRepository;
	
	@Autowired
	ItemPedidoRepository itemPedidoRepository;
	
	@ApiOperation(value=" Return List Products")
	@GetMapping("/produtos")
	public List<Produto> listaProdutos(){
		
		return produtosRepository.findAll();
	}
	
	@ApiOperation(value=" Return List Pedidos")
	@GetMapping("/pedidos")
	public List<Pedido> listaPedidos(){
		List<Pedido> pedidos= pedidosRepository.findAll();
		return  pedidos;
	}
	
	@ApiOperation(value="Find Products By Name")
    @RequestMapping(value = "produtos/{name}", method = RequestMethod.GET)
	public List<Produto> findByName(@PathVariable(value = "name") String name) {
		return produtosRepository.findByName(name);
	}
	
    @ApiOperation(value=" Post Products")
	@PostMapping("/produto")
	public Produto salvarProduto(@RequestBody Produto produto) throws Exception {
		return produtosRepository.save(produto);
	}
    
    @ApiOperation(value=" Salvar Pedido")
	@PostMapping("/pedido")
	public Pedido salvarPedido(@RequestBody Pedido pedido) throws Exception {

    	Pedido p = pedidosRepository.save(pedido);
    	
    /*	for(ItemPedido i : pedido.getItemPedido()) {
    		i.setPedido(pedido);
    		itemPedidoRepository.save(i);
    	}*/
    	
    	
     	return p;
	}
	
    @ApiOperation(value="Delete Products")
	@DeleteMapping("/produto")
	public void deletePoints(@RequestBody Produto produto) {
    	produtosRepository.delete(produto);
		
	}
	
    @ApiOperation(value="Update Products")
	@PutMapping("/produto")
	public Produto updatePoints(@RequestBody Produto produto) {
		return produtosRepository.save(produto);
	}
    
	
}
