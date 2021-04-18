package online.feiranamao.core.repository;

import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;

@Repository
public class PedidosRepository implements PedidosRepository{

    @PersistenceContext
    EntityManager entityManager;
    
    

}