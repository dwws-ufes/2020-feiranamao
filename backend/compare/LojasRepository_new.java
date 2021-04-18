package br.com.feiranamao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.feiranamao.model.Loja;
import br.com.feiranamao.model.Usuario;

public interface LojasRepository
		extends JpaRepository<Loja, String> {
  
  public Loja findById(Long id);
	
	Loja findByUsuario(Usuario usuario);
	
}
