package br.com.feiranamao.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableAuthorizationServer
@EnableResourceServer
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	 @Override
	public void configure(HttpSecurity http) throws Exception {
 
		  http.authorizeRequests()
	        .antMatchers("/login",
	         		  "/ide/**"
	        		,"/v2/"
	        		,"/v2/**"
        		  , "/resources/**"
        		  ,"/webjars/**", "/swagger/**"
        		  ,"/css/**"
        		  ,"/configuration/**"
        		  ,"/swagger-resources/**"
        		  , "/v2/api-docs",
	        		"/swagger/**",
	        		"/v3/**"
	        		,"/v2/api-docs/**"
	        		,"/api-docs/"
	        		,"/api-docs/**"
	        		,"/v3/api-docs"
	        		,"/v3/api-docs/**", 
	        		"/configuration/ui",
	        		"/swagger-resources",
	        		"/configuration/security",
	        		"/swagger-ui.html",
	        		"/webjars/**",
	        		"/swagger-resources/configuration/ui", 
	        		"/swagger-ui.html",
	        		"/swagger-resources/configuration/security",
	        		"/swagger-ui/**"
	        		,"/error/**"
	        		,"/v2/api-docs/.yaml"
	        		,"/v2/api-docs/swagger-config"
	        		,"/participant/**"
	        		,"/swagger-ui/"
	        		,"/swagger-ui/**"
	        		,"/swagger-ui"
	        		).permitAll()
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
                              .antMatchers("/login",
                	         		  "/ide/**"
                  	        		,"/v2/"
                  	        		,"/v2/**"
                            		  , "/resources/**"
                            		  ,"/webjars/**", "/swagger/**"
                            		  ,"/css/**"
                            		  ,"/configuration/**"
                            		  ,"/swagger-resources/**"
                            		  , "/v2/api-docs",
                  	        		"/swagger/**",
                  	        		"/v3/**"
                  	        		,"/v2/api-docs/**"
                  	        		,"/api-docs/"
                  	        		,"/api-docs/**"
                  	        		,"/v3/api-docs"
                  	        		,"/v3/api-docs/**", 
                  	        		"/configuration/ui",
                  	        		"/swagger-resources",
                  	        		"/configuration/security",
                  	        		"/swagger-ui.html",
                  	        		"/webjars/**",
                  	        		"/swagger-resources/configuration/ui", 
                  	        		"/swagger-ui.html",
                  	        		"/swagger-resources/configuration/security",
                  	        		"/swagger-ui/**"
                  	        		,"/error/**"
                  	        		,"/v2/api-docs/.yaml"
                  	        		,"/v2/api-docs/swagger-config"
                  	        		,"/participant/**"
                  	        		,"/swagger-ui/"
                  	        		,"/swagger-ui/**"
                  	        		,"/swagger-ui");
      }

}

/*@EnableAuthorizationServer
@EnableResourceServer*/

/*"/**","/login",
	         		  "/ide/**"
	        		,"/v2/"
	        		,"/v2/**"
          		  , "/resources/**"
          		  ,"/webjars/**", "/swagger/**"
          		  ,"/css/**"
          		  ,"/configuration/**"
          		  ,"/swagger-resources/**"
          		  , "/v2/api-docs",
	        		"/swagger/**",
	        		"/v3/**"
	        		,"/v2/api-docs/**"
	        		,"/api-docs/"
	        		,"/api-docs/**"
	        		,"/v3/api-docs"
	        		,"/v3/api-docs/**", 
	        		"/configuration/ui",
	        		"/swagger-resources",
	        		"/configuration/security",
	        		"/swagger-ui.html",
	        		"/webjars/**",
	        		"/swagger-resources/configuration/ui", 
	        		"/swagger-ui.html",
	        		"/swagger-resources/configuration/security",
	        		"/swagger-ui/**"
	        		,"/error/**"
	        		,"/v2/api-docs/.yaml"
	        		,"/v2/api-docs/swagger-config"
	        		,"/participant/**"
	        		,"/swagger-ui/"
	        		,"/swagger-ui/**"
	        		,"/swagger-ui"*/