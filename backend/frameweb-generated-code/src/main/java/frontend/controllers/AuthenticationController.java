package /frontend/controllers;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = "session")
@Component(value = "authenticationController")
@ELBeanName(value = "authenticationController")
@Join(path = "FROM", to = "TO")
public class AuthenticationController {

	

	
	private String usuario;
	
	private String senha;
	

	
	public String autenticaUsuario(String usuario, String senha) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	

}