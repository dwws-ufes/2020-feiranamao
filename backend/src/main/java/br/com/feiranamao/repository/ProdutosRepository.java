package br.com.feiranamao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.feiranamao.model.Loja;
import br.com.feiranamao.model.Produto;

public interface ProdutosRepository
		extends JpaRepository<Produto, String> {
	
	List<Produto> findByName(String name);

	public List<Produto> findByLoja(Loja loja);
}
