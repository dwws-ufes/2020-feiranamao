package br.com.feiranamao.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@Configuration
@EnableWebSecurity
@EnableAuthorizationServer
@EnableResourceServer
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	 @Autowired
	    private UserDetailsService userDetailsService;

	    @Autowired
	    private PasswordEncoder passwordEncoder;
	    
	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManager();
	}
	
 /* @Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.inMemoryAuthentication()
		.withUser("feiraadmin")
		.password("feiraadmin")
		.roles("ADMIN");
	}*/
  
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth.authenticationProvider(authenticationProvider());
  }
  
  @Bean
  public DaoAuthenticationProvider authenticationProvider(){
      DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
      provider.setPasswordEncoder(passwordEncoder);
      provider.setUserDetailsService(userDetailsService);
      return provider;
  }
	
	 @Override
	public void configure(HttpSecurity http) throws Exception {
 
		  http.authorizeRequests()
	        .antMatchers(
	        		 "swagger.json"
            		,"/login"
	         		,"/ide/**"
  	        		,"/v2/"
  	        		,"/v2/**"
            		, "/resources/**"
            		,"/webjars/**", "/swagger/**"
            		,"/css/**"
            		,"/configuration/**"
            		,"/swagger-resources/**"
            		, "/v2/api-docs"
  	        		,"/swagger/**"
  	        		,"/v3/**"
  	        		,"/v2/api-docs/**"
  	        		,"/api-docs/"
  	        		,"/api-docs/**"
  	        		,"/v3/api-docs"
  	        		,"/v3/api-docs/**" 
  	        		,"/configuration/ui"
  	        		,"/swagger-resources"
  	        		,"/configuration/security"
  	        		,"/swagger-ui.html"
  	        		,"/webjars/**"
  	        		,"/swagger-resources/configuration/ui" 
  	        		,"/swagger-ui.html"
  	        		,"/swagger-resources/configuration/security"
  	        		,"/swagger-ui/**"
  	        		,"/error/**"
  	        		,"/v2/api-docs/.yaml"
  	        		,"/v2/api-docs/swagger-config"
  	        		,"/participant/**"
  	        		,"/swagger-ui/"
  	        		,"/swagger-ui/**"
  	        		,"/swagger-ui").permitAll()
	        .antMatchers("/admin/**").hasRole("ADMIN")
	        .antMatchers("/**","/produtos/**","/produtos").hasAnyRole("ADMIN", "USER")
	        .and().formLogin()
	        .and().logout().logoutSuccessUrl("/login").permitAll()
	        .and().csrf().disable();
			
	  }
	  
	//  @Override
      public void configure(WebSecurity web) throws Exception {
              web.ignoring()
              // Spring Security should completely ignore URLs starting with /resources/
                              .antMatchers(
                            		"swagger.json"
                            		,"/login"
                	         		,"/ide/**"
                  	        		,"/v2/"
                  	        		,"/v2/**"
                            		, "/resources/**"
                            		,"/webjars/**", "/swagger/**"
                            		,"/css/**"
                            		,"/configuration/**"
                            		,"/swagger-resources/**"
                            		, "/v2/api-docs"
                  	        		,"/swagger/**"
                  	        		,"/v3/**"
                  	        		,"/v2/api-docs/**"
                  	        		,"/api-docs/"
                  	        		,"/api-docs/**"
                  	        		,"/v3/api-docs"
                  	        		,"/v3/api-docs/**" 
                  	        		,"/configuration/ui"
                  	        		,"/swagger-resources"
                  	        		,"/configuration/security"
                  	        		,"/swagger-ui.html"
                  	        		,"/webjars/**"
                  	        		,"/swagger-resources/configuration/ui" 
                  	        		,"/swagger-ui.html"
                  	        		,"/swagger-resources/configuration/security"
                  	        		,"/swagger-ui/**"
                  	        		,"/error/**"
                  	        		,"/v2/api-docs/.yaml"
                  	        		,"/v2/api-docs/swagger-config"
                  	        		,"/participant/**"
                  	        		,"/swagger-ui/"
                  	        		,"/swagger-ui/**"
                  	        		,"/swagger-ui");
      }

}