package br.com.feiranamao.model;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="CATEGORIA")
public class Categoria implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
		@Id 
		@NotNull
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_categoria")
		@SequenceGenerator(name="seq_categoria", sequenceName = "seq_categoria", initialValue = 1)
		private long id;
		
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

		private String name;
	
}
