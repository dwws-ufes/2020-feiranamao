package br.com.xyinc;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.feiranamao.model.Produto;
import br.com.feiranamao.repository.ReferencesRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProdutosRepositoryTest {
		
	/*	@Autowired
		private PointsRepository pointsRepository;
		
		@Autowired
		private ReferencesRepository referenceRepository;
		
		@Rule
		public ExpectedException thrown = ExpectedException.none();
		
		@Test
		public void createShouldPersitsPoints() {
			Produto points = new Produto();
			points.setName("Lanchonete");
			points.setX(27);
			points.setY(12);
			
			this.pointsRepository.save(points);
			
			assertThat(points.getName()).isNotNull();
			assertThat(points.getX()).isNotNull();
			assertThat(points.getY()).isNotNull();
			
		}
		
		@Test
		public void findAllPoints() {
			
			//TODO Em outro cenário, outro teste seria necessário, para não iniciar com um delete
			this.pointsRepository.deleteAll();
			
			ArrayList<Produto>  points = new ArrayList<Produto>();
			points.add(new Produto("Lanchonete", 27, 12));
			points.add(new Produto("Posto", 31, 18));
			points.add(new Produto("Joalheria", 15, 12));
			points.add(new Produto("Floricultura", 19, 21));
			points.add(new Produto("Pub", 12, 8));
			points.add(new Produto("Supermercado", 23, 6));
			points.add(new Produto("Churrascaria", 28, 2));
			
			for(Produto p: points)
				this.pointsRepository.save(p);
			
			List<Produto> foundPoints  = this.pointsRepository.findAll();
			
			assertThat(foundPoints.size()).isEqualTo(7);
		}
		
		@Test
		public void findReferencePoints() {
			
			//TODO Somente para demostração, em cenário de produção outra logica seria aplicada.
			this.pointsRepository.deleteAll();
			
			ArrayList<Produto>  points = new ArrayList<Produto>();
			points.add(new Produto("Lanchonete", 27, 12));
			points.add(new Produto("Posto", 31, 18));
			points.add(new Produto("Joalheria", 15, 12));
			points.add(new Produto("Floricultura", 19, 21));
			points.add(new Produto("Pub", 12, 8));
			points.add(new Produto("Supermercado", 23, 6));
			points.add(new Produto("Churrascaria", 28, 2));
			
			for(Produto p: points)
				this.pointsRepository.save(p);
			
			References reference = new References(20, 10, 10.0);
			
			List<Produto> foundPoints  = this.referenceRepository
											 .findAllReferences(
																reference.getX(),
																reference.getY(),
																reference.getM()
																);	
			assertThat(foundPoints.size()).isEqualTo(4);
		}
		
*/
		
		
}
