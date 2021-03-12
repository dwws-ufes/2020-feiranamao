package /frontend/controllers;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = "session")
@Component(value = "pedidoController")
@ELBeanName(value = "pedidoController")
@Join(path = "FROM", to = "TO")
public class pedidoController {

	

	
	private List itemsPedido;
	

	
	public Pedido fazerPedido(List ItemsPedido, String usuarioId, String lojaId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	public List getItemsPedido() {
		return itemsPedido;
	}

	public void setItemsPedido(List itemsPedido) {
		this.itemsPedido = itemsPedido;
	}
	

}