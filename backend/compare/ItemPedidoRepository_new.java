package br.com.feiranamao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.feiranamao.model.ItemPedido;

public interface ItemPedidoRepository
		extends JpaRepository<ItemPedido, String> {
	
}
