package online.feiranamao.core.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceBean implements LoginServiceBean {
	
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	

	
		
		
		
		
	@Override
	public Optional<UsuarioDAO> findUsuarioDAOById(Long id) {
		return usuarioDAO.findById(id);
	}	
	
	@Override
	public List<UsuarioDAO> findAllUsuarioDAOs() {
		return usuarioDAO.findAll();
	}
	
	@Override
	public UsuarioDAO saveUsuarioDAO(UsuarioDAO usuarioDAO) {
		return usuarioDAO.save(usuarioDAO);
	}
	
	@Override
	public void deleteUsuarioDAO(UsuarioDAO usuarioDAO) {
		usuarioDAO.delete(usuarioDAO);
	}
	
	
	

	
	
	
	@Override
	public void checaLogin(String usuario, String senha) {
		// TODO Auto-generated method stub
		return;
	}
	
}