package br.com.feiranamao.config;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.reactive.config.WebFluxConfigurer;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.security.OAuthFlow;
import io.swagger.v3.oas.models.security.OAuthFlows;
import io.swagger.v3.oas.models.security.Scopes;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@Configuration
@EnableSwagger2WebFlux
public class SwaggerConfiguration implements WebFluxConfigurer { 

	@Bean
	public Docket api() {
	    return new Docket(DocumentationType.SWAGGER_2)
	      .apiInfo(apiInfo())
	      .securityContexts(Arrays.asList(securityContext()))
	      .securitySchemes(Arrays.asList(apiKey()))
	      .select()
	      .apis(RequestHandlerSelectors.basePackage("br.com.feiranamao"))  
	      .paths(PathSelectors.any())
	      .build();
	} 
	
	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				 .components(new Components()
						 
	                        .addSecuritySchemes("Basic", new SecurityScheme()
	    							.type(SecurityScheme.Type.HTTP)
	    							.scheme("basic")
	    					)
	                        
	                        .addSecuritySchemes("Bearer",
	       		                 new SecurityScheme().type(SecurityScheme.Type.HTTP)
	       		                 .scheme("bearer").bearerFormat("JWT")
	       		                .in(SecurityScheme.In.HEADER).name("Authorization"))
	                        
	                        .addParameters("Version", new Parameter()
	                                .in("header")
	                                .name("Version")
	                                .schema(new StringSchema())
	                                .required(false)))
				 
				 			.security(Arrays.asList(
	                        new SecurityRequirement().addList("Basic"),
	                        new SecurityRequirement().addList("Bearer")))
				 			
	               .info(new Info()
				.title("Feira na mão")
				 .version("2.1a")
				 .description("\nAPI desenvolvida pelos alunos de graduação e mestrado da UFES."
				 		+ "\n<br><br>Sendo parte aplicação construida para a como trabalho avaliativo da disciplina de Desenvolvimeto Web e Web Semantica."
				 		+ "\n<br><br>O códido está aberto e hospedado no GitHub da disciplina em DWWS 2020 UFES [dwws-ufes](https://github.com/dwws-ufes/2020-feiranamao)."
				 		+ "\n<br><br>Utilizamos no projeto OAUTH2 acesso aos recursos. "
				 		+ "\n<br>"
				 		+ "\n<br><b>Passos:</b>"
				 		+ "\n<br>"
				 		+ "\n<br>`1.` Antes de realizar a requisição de autenticação é necessário informar as credenciais de acesso `Basic` para testes de autorização."
				 		+ "\n<br> <b>username: </b>feiranamao <b>password: </b> fer123@@ "
				 		+ "\n<br>"
				 		+ "\n<br>`2.` Logo após é possível requisitar a chave de autenticação JWT. "
				 		+ "<br><b>grant_type: </b>password <b>username: </b>application-user <b>password: </b> password "
				 		+ "\n<br>"
				 		+ "\n<br>`3.` Em posse do token é necessário remover as credenciais `basic` e inserir o token `bearer` utilizando o botão `Authorize`"
				 		+ "\n<br>"
				 		+ "\n<br>`4.` Estando devidamente autorizado é possível utilizar os recursos.")
				 
				 .termsOfService("https://github.com/dwws-ufes/2020-feiranamao")
				 .license(new License().name("UFES").url("https://github.com/dwws-ufes/2020-feiranamao")));
	}
	 private ApiInfo apiInfo() {
		    return new ApiInfo(
		      "Feira na mão 1.0",
		      "Api desenvolvida pelos alunos de graduação e metrado da ufes",
		      "1.0",
		      "Terms of service",
		      new Contact("UFES", "https://github.com/dwws-ufes/2020-feiranamao", "ufes@ufes.com"),
		      "License of API",
		      "API license URL",
		      Collections.emptyList());
		}
	 
	 private ApiKey apiKey() { 
		    return new ApiKey("Bearer", "Authorization", "header"); 
		}
	 
	 private SecurityContext securityContext() { 
		    return SecurityContext.builder().securityReferences(defaultAuth()).build(); 
		} 

		private List<SecurityReference> defaultAuth() { 
		    AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything"); 
		    AuthorizationScope[] authorizationScopes = new AuthorizationScope[1]; 
		    authorizationScopes[0] = authorizationScope; 
		    return Arrays.asList(new SecurityReference("JWT", authorizationScopes)); 
		}
}
