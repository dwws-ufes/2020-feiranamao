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
public class Loja implements Serializable {

	private static final long serialVersionUID = 1L;



    
	@NotNull
	@Column(name = "nome", unique = true)
	private  nome;
    

    
	@NotNull
	@Column(name = "id", unique = true)
	public String id;
    




		
		@OneToMany(mappedBy="Target")
		private Set<Produto> Source;
		
	

		
		@OneToOne
		@JoinColumn(name = "Target_id")
		private Usuario Target;
		
	

		
		@OneToMany(mappedBy="Target")
		private Set<Pedido> Source;
		
	


	public Loja() {
		super();
	}



	public  getNome() {
		return nome;
	}
	
	public void setNome( nome) {
		this.nome = nome;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}




		
		public Set<Produto> getSource() {
			return Source;
		}
		
		public void setSource(Set<Produto> Source) {
			this.Source = Source;
		}
		
	

		
		public Usuario getTarget() {
			return Target;
		}
		
		public void setTarget(Usuario Target) {
			this.Target = Target;
		}
		
	

		
		public Set<Pedido> getSource() {
			return Source;
		}
		
		public void setSource(Set<Pedido> Source) {
			this.Source = Source;
		}
		
	





}