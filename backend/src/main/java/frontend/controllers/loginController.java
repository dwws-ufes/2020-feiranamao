package /frontend/controllers;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = "session")
@Component(value = "loginController")
@ELBeanName(value = "loginController")
@Join(path = "FROM", to = "TO")
public class loginController {

	

	

	
	public void submit() {
		// TODO Auto-generated method stub
		return;
	}
	
	
	

}