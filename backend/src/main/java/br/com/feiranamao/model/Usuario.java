package br.com.feiranamao.model;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="USUARIO")
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
		@Id 
		@NotNull
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuario")
		@SequenceGenerator(name="seq_usuario", sequenceName = "seq_usuario", initialValue = 1)
		private long id;
		
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getLogin() {
			return login;
		}
		public void setLogin(String login) {
			this.login = login;
		}
		public String getSenha() {
			return senha;
		}
		public void setSenha(String senha) {
			this.senha = senha;
		}
		private String nome;
		private String login;
		private String senha;
	
	
}
