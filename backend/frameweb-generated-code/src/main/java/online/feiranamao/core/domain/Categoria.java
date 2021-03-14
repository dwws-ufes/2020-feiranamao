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
public class Categoria implements Serializable {

	private static final long serialVersionUID = 1L;



    
	@NotNull
	@Column(name = "id", unique = true)
	public String id;
    

    
	@NotNull
	@Column(name = "nome", unique = true)
	private String nome;
    




		
		@OneToMany(mappedBy="Target")
		private Set<Produto> Source;
		
	


	public Categoria() {
		super();
	}



	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}




		
		public Set<Produto> getSource() {
			return Source;
		}
		
		public void setSource(Set<Produto> Source) {
			this.Source = Source;
		}
		
	





}