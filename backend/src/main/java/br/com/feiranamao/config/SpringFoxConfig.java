package br.com.feiranamao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@EnableSwagger2
@Import(SpringDataRestConfiguration.class)
public class SpringFoxConfig {

	 @Bean
	    public Docket api() { 
	        return new Docket(DocumentationType.SWAGGER_2)  
	           .groupName("UM TESTE")
	          .select()                                  
	          .apis(RequestHandlerSelectors.basePackage("br.com.feiranamao"))            
	          .paths(PathSelectors.any())                          
	          .build()
	          .apiInfo(metaData());                                           
	    }
	 
	  private ApiInfo metaData() {
		    return new ApiInfoBuilder()
		        .title("API FEIRA NA MAO")
		        .description("\"Spring Boot REST API for UFES \"")
		        .version("1.0.0")
		        .license("licence")
		        .contact( new Contact("Alunos", 
		        		"https://www.linkedin.com/in/alunos/",
		        		"a@edu.ufes.com.br"))
		        .licenseUrl("https://www.xy.inc/licenses/LICENSE-2.0\"")
		        .build();
		  }
}
