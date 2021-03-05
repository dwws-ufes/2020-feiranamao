package online.feiranamao.core.dao;

import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;

@Repository
public class ProdutoDAOJPA implements ProdutoDAOJPA{

    @PersistenceContext
    EntityManager entityManager;
    
    

}