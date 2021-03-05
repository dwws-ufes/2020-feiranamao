package br.com.feiranamao.model;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="ITEMPEDIDO")
public class ItemPedido implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
		@Id 
		@NotNull
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long id;
		
		/*@ManyToOne
	    @JoinColumn(name="pedido_id")
	    private Pedido pedido;
		*/

		private Double valorUnitario;
		private Double quantidade;
		private Double valorTotal;

		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public Double getValorUnitario() {
			return valorUnitario;
		}
		public void setValorUnitario(Double valorUnitario) {
			this.valorUnitario = valorUnitario;
		}
		public Double getQuantidade() {
			return quantidade;
		}
		public void setQuantidade(Double quantidade) {
			this.quantidade = quantidade;
		}
		public Double getValorTotal() {
			return valorTotal;
		}
		public void setValorTotal(Double valorTotal) {
			this.valorTotal = valorTotal;
		}
		/*public Pedido getPedido() {
			return pedido;
		}
		public void setPedido(Pedido pedido) {
			this.pedido = pedido;
		}*/
	
}
