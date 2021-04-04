package br.com.feiranamao.model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.mapping.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="USUARIO")
public class Usuario implements UserDetails {

	private static final long serialVersionUID = 1L;

			@Id
		    @GeneratedValue(strategy = GenerationType.AUTO)
		    private Long id;

//			@Column(name = "username")
			@NotNull
		    private String login;
		    
		    @NotNull
		    private String nome;

//		    @Column(name = "password")
		    @NotNull
		    private String senha;
		    
		    private boolean dono;

		    private boolean accountNonExpired;

		    private boolean accountNonLocked;

		    private boolean credentialsNonExpired;
		    
		    private boolean enabled; 
		    
//		    @JsonManagedReference
 		    @OneToOne(optional=true, fetch = FetchType.LAZY, mappedBy = "usuario")
		    private Loja loja;
		    
			/*  
			 @Enumerated(EnumType.STRING)
		    @ElementCollection(fetch = FetchType.EAGER)
		    private List<Role> roles;
			 */
		    public Usuario() {
		        this.accountNonExpired = true;
		        this.accountNonLocked = true;
		        this.credentialsNonExpired = true;
		        this.enabled = true;
		    }

		    @Override
		    public String getUsername() {
		        return login;
		    }
		    
		    @Override
		    public String getPassword() {
		        return senha;
		    }
		    
		    @Override
		    public boolean isAccountNonExpired() {
		        return accountNonExpired;
		    }

		    @Override
		    public boolean isAccountNonLocked() {
		        return accountNonLocked;
		    }

		    @Override
		    public boolean isCredentialsNonExpired() {
		        return credentialsNonExpired;
		    }

		    @Override
		    public boolean isEnabled() {
		        return true;
		    }

			@Override
			public Collection<? extends GrantedAuthority> getAuthorities() {
				// TODO Auto-generated method stub
				return null;
			}

			public Long getId() {
				return id;
			}
			
			public String getLogin() {
				return login;
			}

			public void setLogin(String login) {
				this.login = login;
			}

			public String getNome() {
				return nome;
			}

			public void setNome(String nome) {
				this.nome = nome;
			}

			public String getSenha() {
				return senha;
			}

			public void setSenha(String senha) {
				this.senha = senha;
			}

			public boolean isDono() {
				return dono;
			}

			public void setDono(boolean dono) {
				this.dono = dono;
			}

			public Loja getLoja() {
				return loja;
			}

//			public void setLoja(Loja loja) {
//				this.loja = loja;
//			}			
		
}
