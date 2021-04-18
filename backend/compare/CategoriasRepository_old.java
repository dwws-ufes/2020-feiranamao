package online.feiranamao.core.repository;

import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;

@Repository
public class CategoriasRepository implements CategoriasRepository{

    @PersistenceContext
    EntityManager entityManager;
    
    

}