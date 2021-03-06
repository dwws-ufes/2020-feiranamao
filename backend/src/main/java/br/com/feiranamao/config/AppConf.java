package br.com.feiranamao.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Profile("development")
public class AppConf implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
    	 registry.addMapping("/**")
         .allowedOrigins("localhost")
         .allowCredentials(true)
         .allowedMethods("GET", "POST", "DELETE", "PUT", "PATCH")
         .maxAge(3600);
    }
}