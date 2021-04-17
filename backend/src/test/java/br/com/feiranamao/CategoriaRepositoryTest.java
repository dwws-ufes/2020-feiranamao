package br.com.feiranamao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.feiranamao.model.Categoria;
import br.com.feiranamao.repository.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CategoriaRepositoryTest {
		
		@Autowired
		private CategoriasRepository categoriasRepository;
		
		@Autowired
		private ProdutosRepository produtoRepository;
		
		@Rule
		public ExpectedException thrown = ExpectedException.none();
		
		@Test
		public void testCategorias() {
			Categoria categoria = new Categoria();
			categoria.setName("Teste");
			
			this.produtoRepository.deleteAll();	
			this.categoriasRepository.deleteAll();	
			
			this.categoriasRepository.save(categoria);
			
			List<Categoria> result = this.categoriasRepository.findAll();

			assertEquals(result.size(),1);
			
		}
		
}
