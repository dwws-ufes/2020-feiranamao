package br.com.feiranamao.model;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="PRODUTO")
public class Produto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
		@Id 
		@NotNull
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long id;

		private String name;
		private String descricao;
		private Double preco;
		private Double custo;
		private Double estoque;
		private long id_categoria;
		
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

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
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
		
		public long getId_categoria() {
			return id_categoria;
		}

		public void setId_categoria(long id_categoria) {
			this.id_categoria = id_categoria;
		}

}
