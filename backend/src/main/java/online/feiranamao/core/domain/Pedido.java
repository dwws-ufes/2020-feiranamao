//package online.feiranamao.core.domain;
//
//import java.io.Serializable;
//import java.util.Set;
//import java.util.List;
//import java.math.BigDecimal;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.OneToOne;
//import javax.persistence.OneToMany;
//import javax.persistence.ManyToOne;
//import javax.persistence.ManyToMany;
//import javax.validation.constraints.NotNull;
//
//@Entity
//public class Pedido implements Serializable {
//
//	private static final long serialVersionUID = 1L;
//
//
//
//    
//	@NotNull
//	@Column(name = "_id", unique = true)
//	private String _id;
//    
//
//    
//	@NotNull
//	@Column(name = "data", unique = true)
//	private  data;
//    
//
//
//
//
//		
//		@ManyToOne
//		@JoinColumn(name = "Source_id")
//		private Usuario Source;
//		
//	
//
//		
//		@OneToMany(mappedBy="Source")
//		private Set<ItemPedido> Target;
//		
//	
//
//		
//		@ManyToMany
//		@JoinTable(
//			name = "Source_Target",
//			joinColumns = @JoinColumn(name = "Source_id"),
//			inverseJoinColumns = @JoinColumn(name = "Target_id")
//		)
//		private Set<Produto> Target;
//		
//	
//
//		
//		@ManyToOne
//		@JoinColumn(name = "Target_id")
//		private Loja Target;
//		
//	
//
//
//	public Pedido() {
//		super();
//	}
//
//
//
//	public String get_id() {
//		return _id;
//	}
//	
//	public void set_id(String _id) {
//		this._id = _id;
//	}
//
//	public  getData() {
//		return data;
//	}
//	
//	public void setData( data) {
//		this.data = data;
//	}
//
//
//
//
//		
//		public Usuario getSource() {
//			return Source;
//		}
//		
//		public void setSource(Usuario Source) {
//			this.Source = Source;
//		}
//		
//	
//
//		
//		public Set<ItemPedido> getTarget() {
//			return Target;
//		}
//		
//		public void setTarget(Set<ItemPedido> Target) {
//			this.Target = Target;
//		}
//		
//	
//
//		
//		public Set<Produto> getTarget() {
//			return Target;
//		}
//		
//		public void setTarget(Set<Produto> Target) {
//			this.Target = Target;
//		}
//		
//	
//
//		
//		public Loja getTarget() {
//			return Target;
//		}
//		
//		public void setTarget(Loja Target) {
//			this.Target = Target;
//		}
//		
//	
//
//
//
//
//
//}