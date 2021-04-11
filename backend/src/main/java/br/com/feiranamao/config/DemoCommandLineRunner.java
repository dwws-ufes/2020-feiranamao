package br.com.feiranamao.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import br.com.feiranamao.model.Categoria;
import br.com.feiranamao.model.Usuario;
import br.com.feiranamao.repository.CategoriasRepository;
import br.com.feiranamao.repository.UsuarioRepository;

@Component
class DemoCommandLineRunner implements CommandLineRunner{

	@Autowired
	private UsuarioRepository userRepository;
	
	@Autowired
	private CategoriasRepository catRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) throws Exception {

		Optional<Usuario> old= userRepository.findByLogin("application-user");

		if(old.isEmpty()) {
			Usuario user = new Usuario();
			user.setLogin("application-user");
			user.setNome("SuperAdmin");
			user.setSenha(passwordEncoder.encode("password"));
			//user.grantAuthority("ADMIN");
			userRepository.save(user);
			
			Categoria cat = new Categoria();
			cat.setName("Folha");
			catRepository.save(cat);
			
			cat = new Categoria();
			cat.setName("Legume");
			catRepository.save(cat);
			
			cat = new Categoria();
			cat.setName("Fruta");
			catRepository.save(cat);
			
			cat = new Categoria();
			cat.setName("Grão");
			catRepository.save(cat);
			
			cat = new Categoria();
			cat.setName("Raiz");
			catRepository.save(cat);
			
			cat = new Categoria();
			cat.setName("Outros");
			catRepository.save(cat);
			
		}
	}
}