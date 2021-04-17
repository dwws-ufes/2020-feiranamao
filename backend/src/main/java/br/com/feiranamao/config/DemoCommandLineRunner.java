package br.com.feiranamao.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import br.com.feiranamao.model.Categoria;
import br.com.feiranamao.model.Loja;
import br.com.feiranamao.model.Produto;
import br.com.feiranamao.model.Usuario;
import br.com.feiranamao.repository.CategoriasRepository;
import br.com.feiranamao.repository.LojasRepository;
import br.com.feiranamao.repository.ProdutosRepository;
import br.com.feiranamao.repository.UsuarioRepository;

@Component
class DemoCommandLineRunner implements CommandLineRunner{

	@Autowired
	private UsuarioRepository userRepository;
	
	@Autowired
	private CategoriasRepository catRepository;
	
	@Autowired
	private LojasRepository lojaRepository;
	
	@Autowired
	private ProdutosRepository produtoRepository;

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
			userRepository.save(user);
						
			Categoria catFolha = new Categoria();
			catFolha.setName("Folha");
			catRepository.save(catFolha);
			
			Categoria catLegume = new Categoria();
			catLegume.setName("Legume");
			catRepository.save(catLegume);
			
			Categoria catFruta = new Categoria();
			catFruta.setName("Fruta");
			catRepository.save(catFruta);
			
			Categoria catGrao = new Categoria();
			catGrao.setName("Grão");
			catRepository.save(catGrao);
			
			Categoria catRaiz = new Categoria();
			catRaiz.setName("Raiz");
			catRepository.save(catRaiz);
			
			Categoria catOutros = new Categoria();
			catOutros.setName("Outros");
			catRepository.save(catOutros);
			/*
			
			/////////////////////////
			user = new Usuario();
			user.setLogin("jose");
			user.setNome("José da Silva");
			user.setSenha(passwordEncoder.encode("jose"));
			user.setDono(true);
			userRepository.save(user);			

				Loja loja = new Loja();
				loja.setNome("Barraca do José"); 
				loja.setLogo("https://i.mgfserv.com/360x270/aHR0cDovL2ltZy5vbHguY29tLmJyL2ltYWdlcy8wNy8wNzE2MjUwMjk1MzQwMTcuanBn.jpg");
				loja.setUsuario(user);
				lojaRepository.save(loja);
				
//				Produto produto = new Produto();
//				produto.setName("Táioba");
//				produto.setUrl("https://lh3.googleusercontent.com/proxy/4Dz-MTwXwQWwnfiChe4SnJPNr8yQWV20xlUcZC6yx8oZMamY5EGRpSs4HX_hn0jv3qsPIYfHXZ4Yt5JVfE1UqzhoEQiR8GqXszJyi2mjxxTFhWWmO4c_JA4ks7xPi71Uf_UNy-b3W1oWW74");
//				produto.setDescricao("Plantação própria e derrete na doca.");
//				produto.setCategoria(catFolha);
//				produto.setEstoque(50);
//				produto.setCusto((float)0.2);
//				produto.setPreco(1);
				
			
			user = new Usuario();
			user.setLogin("ermina");
			user.setNome("Ermina");
			user.setSenha(passwordEncoder.encode("ermina"));
			user.setDono(true);
			userRepository.save(user);

				loja = new Loja();
				loja.setNome("Banca da Melancia"); 
				loja.setLogo("https://midia.gruposinos.com.br/_midias/jpg/2020/01/03/whatsapp_image_2020_01_03_at_09_54_11-18755245.jpeg");
				loja.setUsuario(user);
				lojaRepository.save(loja);
			
			user = new Usuario();
			user.setLogin("joao");
			user.setNome("João Santos");
			user.setSenha(passwordEncoder.encode("joao"));
			user.setDono(true);
			userRepository.save(user);
			
			user = new Usuario();
			user.setLogin("maria");
			user.setNome("Maria da Penha");
			user.setSenha(passwordEncoder.encode("maria"));
			user.setDono(true);
			userRepository.save(user);
			
			user = new Usuario();
			user.setLogin("frederico");
			user.setNome("Frederico Cunha");
			user.setSenha(passwordEncoder.encode("frederico"));
			user.setDono(false);
			userRepository.save(user);
			*/
			
			
		}
	}
}