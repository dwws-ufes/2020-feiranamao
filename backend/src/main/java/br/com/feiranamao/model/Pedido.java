package br.com.feiranamao.model;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="PEDIDO")
public class Pedido implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
		@Id 
		@NotNull
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pedido")
		@SequenceGenerator(name="seq_pedido", sequenceName = "seq_pedido", initialValue = 1)
		private long pedido_id;
		
		@OneToMany(targetEntity =  ItemPedido.class, cascade =CascadeType.ALL)
		@JoinColumn(name="id_pedido", referencedColumnName = "pedido_id")
	    private Set<ItemPedido> itemPedido;

		public Set<ItemPedido> getItemPedido() {
			return itemPedido;
		}
		
		public long getId_loja() {
			return id_loja;
		}

		public void setId_loja(long id_loja) {
			this.id_loja = id_loja;
		}

		private long id_loja;

		public void setItemPedido(Set<ItemPedido> itemPedido) {
			this.itemPedido = itemPedido;
		}

		public long getPedido_id() {
			return pedido_id;
		}

		public void setPedido_id(long pedido_id) {
			this.pedido_id = pedido_id;
		}
		
		private String obs;
		
		public String getObs() {
			return obs;
		}

		public void setObs(String obs) {
			this.obs = obs;
		}

}
