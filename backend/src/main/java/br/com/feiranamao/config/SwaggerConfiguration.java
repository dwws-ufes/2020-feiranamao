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
				 .description("Api desenvolvida pelos alunos de graduação e metrado da ufes")
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
