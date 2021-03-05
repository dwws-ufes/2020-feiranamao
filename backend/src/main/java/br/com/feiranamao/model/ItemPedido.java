package br.com.feiranamao.model;
import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="ITEMPEDIDO")
public class ItemPedido implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/*	@EmbeddedId
	    private ItemPedidoID itemPedidoID;

		public ItemPedidoID getItemPedidoID() {
			return itemPedidoID;
		}
		public void setItemPedidoID(ItemPedidoID itemPedidoID) {
			this.itemPedidoID = itemPedidoID;
		}*/
	   
		@Id 
		@NotNull
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_item")
		@SequenceGenerator(name="seq_item", sequenceName = "seq_item", initialValue = 1)
		private long id;
		
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		private Double valorUnitario;
		private Double quantidade;
		private Double valorTotal;

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
	
}
