package online.feiranamao.core.application;

import java.util.List;
import java.util.Optional;

public interface PedidoService {

	
	public Pedido fazerPedido(List itensPedido, String usuarioId, String lojaId);
	
	
	
	
	public Optional<Pedido> findPedidoById(Long id);
	public List<Pedido> findAllPedidos();
	public Pedido savePedido(Pedido pedido);
	public void deletePedido(Pedido pedido);

}