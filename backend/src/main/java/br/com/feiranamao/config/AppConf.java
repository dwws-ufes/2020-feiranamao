package br.com.feiranamao.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class AppConf implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
    	 registry.addMapping("/**")
    	 .allowedOrigins("*")
         .allowedOrigins("localhost")
         .allowedOrigins("http://localhost")
         .allowedOrigins("http://localhost:4200")
         .allowCredentials(true)
         .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT")
         .maxAge(3600);
    }
}