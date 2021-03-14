package online.feiranamao.core.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceBean implements LoginServiceBean {
	
	
	@Autowired
	private JpaRepository jpaRepository;
	

	
		
		
		
		
	@Override
	public Optional<Jpa> findJpaById(Long id) {
		return jpaRepository.findById(id);
	}	
	
	@Override
	public List<Jpa> findAllJpas() {
		return jpaRepository.findAll();
	}
	
	@Override
	public Jpa saveJpa(Jpa jpa) {
		return jpaRepository.save(jpa);
	}
	
	@Override
	public void deleteJpa(Jpa jpa) {
		jpaRepository.delete(jpa);
	}
	
	
	

	
	
	
	@Override
	public void checaLogin(String usuario, String senha) {
		// TODO Auto-generated method stub
		return;
	}
	
}