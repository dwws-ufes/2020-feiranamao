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
//public class Usuario implements Serializable {
//
//	private static final long serialVersionUID = 1L;
//
//
//
//    
//	@NotNull
//	@Column(name = "nome", unique = true)
//	private String nome;
//    
//
//    
//	@NotNull
//	@Column(name = "login", unique = true)
//	private String login;
//    
//
//    
//	@NotNull
//	@Column(name = "senha", unique = true)
//	private String senha;
//    
//
//    
//	@NotNull
//	@Column(name = "_id", unique = true)
//	private String _id;
//    
//
//
//
//
//		
//		@OneToMany(mappedBy="Source")
//		private Set<Pedido> Target;
//		
//	
//
//		
//		@OneToOne(mappedBy="Target")
//		private Loja Source;
//		
//	
//
//
//	public Usuario() {
//		super();
//	}
//
//
//
//	public String getNome() {
//		return nome;
//	}
//	
//	public void setNome(String nome) {
//		this.nome = nome;
//	}
//
//	public String getLogin() {
//		return login;
//	}
//	
//	public void setLogin(String login) {
//		this.login = login;
//	}
//
//	public String getSenha() {
//		return senha;
//	}
//	
//	public void setSenha(String senha) {
//		this.senha = senha;
//	}
//
//	public String get_id() {
//		return _id;
//	}
//	
//	public void set_id(String _id) {
//		this._id = _id;
//	}
//
//
//
//
//		
//		public Set<Pedido> getTarget() {
//			return Target;
//		}
//		
//		public void setTarget(Set<Pedido> Target) {
//			this.Target = Target;
//		}
//		
//	
//
//		
//		public Loja getSource() {
//			return Source;
//		}
//		
//		public void setSource(Loja Source) {
//			this.Source = Source;
//		}
//		
//	
//
//
//
//
//
//}