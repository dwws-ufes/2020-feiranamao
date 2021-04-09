package br.com.feiranamao.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.feiranamao.model.Loja;
import br.com.feiranamao.model.Produto;

public interface ProdutosRepository
		extends JpaRepository<Produto, String> {
	
	List<Produto> findByName(String name);

	public List<Produto> findByLoja(Loja loja);

	@Modifying(clearAutomatically = true)
	@Transactional
  	@Query("UPDATE Produto u SET u.estoque = u.estoque - :incremento WHERE u.id = :id")
	public void setFixedEstoqueFor(@Param("id")long id, @Param("incremento")int quantidade);
}
