package online.feiranamao.core.domain;

import java.io.Serializable;
import java.util.Set;
import java.util.List;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

@Entity
public class ItemPedido implements Serializable {

	private static final long serialVersionUID = 1L;



    
	@NotNull
	@Column(name = "valorUnitario", unique = true)
	private float valorUnitario;
    

    
	@NotNull
	@Column(name = "quantidade", unique = true)
	private int quantidade;
    

    
	@NotNull
	@Column(name = "valorTotal", unique = true)
	private float valorTotal;
    




		
		@ManyToOne
		@JoinColumn(name = "Source_id")
		private Pedido Source;
		
	

		
		@ManyToOne
		@JoinColumn(name = "Target_id")
		private Produto Target;
		
	


	public ItemPedido() {
		super();
	}



	public float getValorUnitario() {
		return valorUnitario;
	}
	
	public void setValorUnitario(float valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public float getValorTotal() {
		return valorTotal;
	}
	
	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}




		
		public Pedido getSource() {
			return Source;
		}
		
		public void setSource(Pedido Source) {
			this.Source = Source;
		}
		
	

		
		public Produto getTarget() {
			return Target;
		}
		
		public void setTarget(Produto Target) {
			this.Target = Target;
		}
		
	





}