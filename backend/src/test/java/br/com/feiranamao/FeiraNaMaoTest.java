package br.com.feiranamao;

import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.feiranamao.model.Categoria;
import br.com.feiranamao.model.Loja;
import br.com.feiranamao.model.Produto;
import br.com.feiranamao.model.Usuario;
import br.com.feiranamao.repository.CategoriasRepository;
import br.com.feiranamao.repository.LojasRepository;
import br.com.feiranamao.repository.ProdutosRepository;
import br.com.feiranamao.repository.UsuarioRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FeiraNaMaoTest {
		
@Autowired
private CategoriasRepository categoriasRepository;

@Autowired
private ProdutosRepository produtosRepository;

@Autowired
private UsuarioRepository usuariosRepostory;

@Autowired
private LojasRepository lojasRepostory;



@Rule
public ExpectedException thrown = ExpectedException.none();

@Test
public void categoriesShouldPersist() {
	
	produtosRepository.deleteAll();
	categoriasRepository.deleteAll();
	
	List<Categoria> categorias = new ArrayList<Categoria>();
	Categoria frutas = new Categoria();
	frutas.setName("Frutas");
	categorias.add(frutas);
	
	Categoria legumes = new Categoria();
	legumes.setName("Legumes");
	categorias.add(legumes);
	
	Categoria verduras = new Categoria();
	verduras.setName("Verduras");
	categorias.add(verduras);
	
	this.categoriasRepository.saveAll(categorias);
	
	 int qtd = this.categoriasRepository.findAll().size();
	 
	assertEquals(qtd,3);
	
}



@Test
public void usuariosShouldPersist() {
	
	produtosRepository.deleteAll();
	categoriasRepository.deleteAll();
	lojasRepostory.deleteAll();
	usuariosRepostory.deleteAll();
	
	
	List<Usuario> usuarios = new ArrayList<Usuario>();
	Usuario leonardo = new Usuario();
	leonardo.setNome("Leonardo");
	leonardo.setLogin("leonardo");
	leonardo.setSenha("123");
	usuarios.add(leonardo);
	
	Usuario ciro = new Usuario();
	ciro.setNome("Ciro");
	ciro.setLogin("ciro");
	ciro.setSenha("123");
	usuarios.add(ciro);
	
	Usuario ryan = new Usuario();
	ryan.setNome("Ryan");
	ryan.setLogin("ryan");
	ryan.setSenha("123");
	usuarios.add(ryan);
	
	Usuario matheus = new Usuario();
	matheus.setNome("Matheus");
	matheus.setLogin("matheus");
	matheus.setSenha("123");
	usuarios.add(matheus);
	
	Usuario rogeiro = new Usuario();
	rogeiro.setNome("Rogerio");
	rogeiro.setLogin("rogerio");
	rogeiro.setSenha("123");
	usuarios.add(rogeiro);
	
	this.usuariosRepostory.saveAll(usuarios);
	
	int qtd = this.usuariosRepostory.findAll().size();
	
	assertEquals(qtd,5);
	
}

@Test
public void produtosShouldPersist() {
	
	produtosRepository.deleteAll();
	categoriasRepository.deleteAll();
	
	Categoria frutas = new Categoria();
	frutas.setName("Frutas");
	categoriasRepository.save(frutas);
	
	Produto abacate = new Produto();
	abacate.setCategoria(frutas);
	abacate.setCusto(Float.parseFloat("1.2"));
	abacate.setEstoque(100);
	abacate.setDescricao("Abacate");
	abacate.setUnidadeVenda("UN");
	abacate.setUrl("https://s2.glbimg.com/ew1z80L80DVKWV8z7XDqQZA4anw=/261x122:4670x3948/924x0/smart/filters:strip_icc()/s.glbimg.com/es/ge/f/original/2014/11/20/abacate.jpg");
	
	int qtd = this.categoriasRepository.findAll().size();
	
	assertEquals(qtd,1);
	
}		
		
}
