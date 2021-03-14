package /frontend/controllers;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = "session")
@Component(value = "produtoController")
@ELBeanName(value = "produtoController")
@Join(path = "FROM", to = "TO")
public class ProdutoController {

	

	
	private Produto Produto;
	

	
	public Produto salvarProduto(Produto Produto) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String deletaProduto(String produtoId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Produto atualizaProduto(Produto Produto) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List getProdutos() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	public Produto getProduto() {
		return Produto;
	}

	public void setProduto(Produto Produto) {
		this.Produto = Produto;
	}
	

}