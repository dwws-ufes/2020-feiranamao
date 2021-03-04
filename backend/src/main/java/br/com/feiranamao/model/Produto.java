package br.com.feiranamao.model;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="PRODUTO")
public class Produto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
		@Id 
		@NotNull
	    @Size(max = 40)
		private long id;

		private String name;
		private long descricao;
		private Double preco;
		private Double custo;
		private Double estoque;
		
		public Produto(){
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public long getDescricao() {
			return descricao;
		}

		public void setDescricao(long descricao) {
			this.descricao = descricao;
		}

		public Double getPreco() {
			return preco;
		}

		public void setPreco(Double preco) {
			this.preco = preco;
		}

		public Double getCusto() {
			return custo;
		}

		public void setCusto(Double custo) {
			this.custo = custo;
		}

		public Double getEstoque() {
			return estoque;
		}

		public void setEstoque(Double estoque) {
			this.estoque = estoque;
		}
}
