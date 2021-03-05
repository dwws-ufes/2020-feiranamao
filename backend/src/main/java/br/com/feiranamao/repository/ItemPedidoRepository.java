package br.com.feiranamao.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.feiranamao.model.ItemPedido;
import br.com.feiranamao.model.Pedido;

public interface ItemPedidoRepository
		extends JpaRepository<ItemPedido, String> {
	
}
