package br.com.feiranamao.model;
import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="LOJA")
public class Loja implements Serializable {
	
	private static final long serialVersionUID = 1L;

		@Id
		@NotNull
//		@GeneratedValue(strategy = GenerationType.AUTO)
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_loja")
		@SequenceGenerator(name="seq_loja", sequenceName = "seq_loja", initialValue = 1)
		private long id;

		@OneToMany(mappedBy = "loja")
		private Set<Produto> produtos;

		private String urlImagem;
		
		public long getId_loja() {
			return id;
		}

		public void setId_loja(long id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getUrl() {
			return urlImagem;
		}

		public void setUrl(String urlImagem) {
			this.urlImagem = urlImagem;
		}

		

		private String nome;
	
}
