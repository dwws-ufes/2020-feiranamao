package br.com.feiranamao.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.feiranamao.model.Produto;

public interface ReferencesRepository
		extends CrudRepository<Produto, Long> {
	/* 
	 * Developer: Leonardo Patrick
	 * Reference: https://www.educamaisbrasil.com.br/enem/matematica/distancia-entre-dois-pontos
	 * 
	 * @param X value coordinate X
	 * @param Y value coordinate Y
	 * @param M value max distance
	 * @return: Points
	 * 
	 */
	
	
	@Query("SELECT c FROM "
			+ " Points c "
			+ " WHERE "
			+ " SQRT(POWER(c.x - :X ,2)  + POWER(c.y - :Y , 2)) < :M ")
	
	List<Produto> findAllReferences(
				 @Param("X") long x
				,@Param("Y") long y
				,@Param("M") Double m);
	
	//static List<Points> findCriteria(){

		/*EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("teste");

		EntityManager em = emf.createEntityManager();

		CriteriaBuilder qb = em.getCriteriaBuilder();

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<VbiCredenciado> criteria = qb.createQuery(tabela1.class);
		
		Root<tabela1> entity = criteria.from(tabela1.class);
		entity.fetch("tabela2"); //join mapiada na entidade

	            criteria.where(cb.equal(entity.get("tabela2").get("colunaNome"), nomeQueQuero));
		criteria.orderBy(cb.asc(entity.get("tabela2").get("colunaNome")));
		Query query = em.createQuery(criteria);
		*/

		
	//}
}
