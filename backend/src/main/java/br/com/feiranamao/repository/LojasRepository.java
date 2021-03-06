package br.com.feiranamao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.feiranamao.model.Loja;

public interface LojasRepository
		extends JpaRepository<Loja, String> {
	
}
