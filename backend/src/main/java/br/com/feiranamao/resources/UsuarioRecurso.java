package br.com.feiranamao.resources;

import java.util.List;
import java.util.Optional;

import br.com.feiranamao.model.Loja;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
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
import br.com.feiranamao.model.Usuario;
import br.com.feiranamao.repository.UsuarioRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="Feira Na Mão")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UsuarioRecurso  {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	
	@ApiOperation(value=" Retorna Lista de Usuarios")
	@GetMapping("/usuarios")
	public List<Usuario> listaUsuario(){
		return usuarioRepository.findAll();
	}

	@ApiOperation(value=" Retorna Usuario logado")
	@GetMapping("/usuario")
	public Usuario getUsuarioAtual(@AuthenticationPrincipal final Usuario user) throws Exception {
		return user;
	}


    @ApiOperation(value="Procurar usuarios por nome")
    @RequestMapping(value = "usuarios/{nome}", method = RequestMethod.GET)
	public Optional<Usuario> findByUsername(@PathVariable(value = "nome") String nome) {
		return usuarioRepository.findByLogin(nome);
	}
	
    @ApiOperation(value=" Salvar Usuario")
	@PostMapping("/usuario")
	public Usuario salvarUsuario(@RequestBody Usuario usuario) throws Exception {
		usuario.setSenha(passwordEncoder.encode(usuario.getPassword()));
		
    	return usuarioRepository.save(usuario);
	}
	
    @ApiOperation(value="Apagar Usuario")
	@DeleteMapping("/usuario/{id}")
	public void deletePoints(@PathVariable(value = "id") Long id) {
    	usuarioRepository.deleteById(id);
	}
	
    @ApiOperation(value="Atualizar Usuario")
	@PutMapping("/usuario")
	public Usuario updatePoints(@RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
    
	
}
