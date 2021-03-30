package br.com.feiranamao.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.feiranamao.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByLogin(String username);
}