package br.com.feiranamao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.feiranamao.model.Pedido;

public interface PedidosRepository
		extends JpaRepository<Pedido, String> {
	
}
