package br.com.feiranamao.model;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="ITEMPEDIDO")
public class ItemPedido implements Serializable {
	
	private static final long serialVersionUID = 1L;
	   
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
		private int quantidade;
		private Double valorTotal;

		public Double getValorUnitario() {
			return valorUnitario;
		}
		public void setValorUnitario(Double valorUnitario) {
			this.valorUnitario = valorUnitario;
		}
		public int getQuantidade() {
			return quantidade;
		}
		public void setQuantidade(int quantidade) {
			this.quantidade = quantidade;
		}
		public Double getValorTotal() {
			return valorTotal;
		}
		public void setValorTotal(Double valorTotal) {
			this.valorTotal = valorTotal;
		}
		public int getId_produto() {
			return id_produto;
		}
		public void setId_produto(int id_produto) {
			this.id_produto = id_produto;
		}
		private int id_produto;
	
}
