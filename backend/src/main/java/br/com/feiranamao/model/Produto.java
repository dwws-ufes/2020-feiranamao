package br.com.feiranamao.model;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="PRODUTO")
public class Produto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
		@Id 
		@NotNull
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_produto")
		@SequenceGenerator(name="seq_produto", sequenceName = "seq_produto", initialValue = 1)
		private long id;

		private String name;
		private String descricao;
		private double preco;
		private double custo;
		private int estoque;
		@ManyToOne
		private Categoria categoria;
		@ManyToOne
		private Loja loja;
		private String urlImagem;
		private String unidadeVenda;
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

		public double getPreco() {
			return preco;
		}

		public void setPreco(float preco) {
			this.preco = preco;
		}

		public double getCusto() {
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

		public Loja getIdLoja() {
			return loja;
		}

		public void setIdLoja(Loja loja) {
			this.loja = loja;
		}
		
		public long getId_categoria() {
			return id_categoria;
		}

		public void setId_categoria(long id_categoria) {
			this.id_categoria = id_categoria;
		}

		public String getUrl() {
			return urlImagem;
		}

		public void setUrl(String urlImagem) {
			this.urlImagem = urlImagem;
		}

		public String getUnidadeVenda() {
			return unidadeVenda;
		}

		public void setUnidadeVenda(String unidadeVenda) {
			this.unidadeVenda = unidadeVenda;
		}

}
