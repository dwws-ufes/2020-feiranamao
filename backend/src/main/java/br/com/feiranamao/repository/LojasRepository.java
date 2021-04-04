package br.com.feiranamao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.feiranamao.model.Loja;
import br.com.feiranamao.model.Usuario;

public interface LojasRepository
		extends JpaRepository<Loja, String> {
	
	Loja findByUsuario(Usuario usuario);	
	
	@Query(value = "SELECT * FROM LOJA WHERE usuario_id = ?1", nativeQuery = true)
	Loja custom(Long user_id);
}
