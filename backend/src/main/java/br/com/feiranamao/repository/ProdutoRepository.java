package br.com.feiranamao.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import online.feiranamao.core.domain.Produto;

public interface ProdutoRepository
		extends JpaRepository<Produto, String> {
	
	List<Produto> findByName(String name);
}