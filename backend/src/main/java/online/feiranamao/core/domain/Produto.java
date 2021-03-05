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
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;



    
	@NotNull
	@Column(name = "_id", unique = true)
	private String _id;
    

    
	@NotNull
	@Column(name = "nome", unique = true)
	private String nome;
    

    
	@NotNull
	@Column(name = "descricao", unique = true)
	private String descricao;
    

    
	@NotNull
	@Column(name = "preco", unique = true)
	private float preco;
    

    
	@NotNull
	@Column(name = "custo", unique = true)
	private float custo;
    

    
	@NotNull
	@Column(name = "estoque", unique = true)
	private int estoque;
    




		
		@OneToMany(mappedBy="Target")
		private Set<ItemPedido> Source;
		
	

		
		@ManyToOne
		@JoinColumn(name = "Target_id")
		private Loja Target;
		
	


	public Produto() {
		super();
	}



	public String get_id() {
		return _id;
	}
	
	public void set_id(String _id) {
		this._id = _id;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getPreco() {
		return preco;
	}
	
	public void setPreco(float preco) {
		this.preco = preco;
	}

	public float getCusto() {
		return custo;
	}
	
	public void setCusto(float custo) {
		this.custo = custo;
	}

	public int getEstoque() {
		return estoque;
	}
	
	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}




		
		public Set<ItemPedido> getSource() {
			return Source;
		}
		
		public void setSource(Set<ItemPedido> Source) {
			this.Source = Source;
		}
		
	

		
		public Loja getTarget() {
			return Target;
		}
		
		public void setTarget(Loja Target) {
			this.Target = Target;
		}
		
	





}