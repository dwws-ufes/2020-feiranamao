package br.com.feiranamao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.feiranamao.model.Categoria;

public interface CategoriasRepository
		extends JpaRepository<Categoria, String> {
	
	List<Categoria> findByName(String name);
}
