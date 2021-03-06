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
import br.com.feiranamao.model.Categoria;
import br.com.feiranamao.repository.CategoriasRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="Feira Na Mão")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CategoriaRecurso  {

	@Autowired
	CategoriasRepository categoriasRepository;
	
	@ApiOperation(value=" Retorna Lista de categoria")
	@GetMapping("/categoria")
	public List<Categoria> listaProdutos(){
		return categoriasRepository.findAll();
	}
	
	@ApiOperation(value="Procurar categoria por nome")
    @RequestMapping(value = "categorias/{nome}", method = RequestMethod.GET)
	public List<Categoria> findByName(@PathVariable(value = "nome") String nome) {
		return categoriasRepository.findByName(nome);
	}
	
    @ApiOperation(value=" Salvar Produto")
	@PostMapping("/categoria")
	public Categoria salvarCategoria(@RequestBody Categoria categoria) throws Exception {
		return categoriasRepository.save(categoria);
	}
	
    @ApiOperation(value="Apagar categoria")
	@DeleteMapping("/categoria")
	public void apagarCategoria(@RequestBody Categoria categoria) {
    	categoriasRepository.delete(categoria);
		
	}
	
    @ApiOperation(value="Atualizar categoria")
	@PutMapping("/categoria")
	public Categoria atualizarCategoria(@RequestBody Categoria categoria) {
		return categoriasRepository.save(categoria);
	}
    
	
}
