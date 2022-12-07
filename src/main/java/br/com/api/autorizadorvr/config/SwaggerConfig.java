package br.com.api.autorizadorvr.config;

import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	private static final String BASE_PAKAGE = "br.com.api.autorizadorvr.controller";
	private static final String API_TITULO = "Autorizador Cartão VR";
	private static final String API_DESCRICAO="Autorizador de cartão de crédito";
	private static final String API_VERSAO = "1.0.0";
	private static final String CONTATO_NAME = "Alexandre B. Santana";
	private static final String CONTATO_GITHUB ="https://github.com/alexandrebs/miniautorizadorVR";
	private static final String  CONTATO_EMAIL ="alexandrebs10@gmail.com";
	
	@Bean
	public Docket api() {
		
		return new Docket(DocumentationType.SWAGGER_2).select().apis( basePackage(BASE_PAKAGE)).paths(PathSelectors.any()).build().apiInfo(buildApiInfo());
	}
	
	private ApiInfo buildApiInfo() {
		return new ApiInfoBuilder()
				.title(API_TITULO)
				.description(API_DESCRICAO)
				.version(API_VERSAO)
				.contact(new springfox.documentation.service.Contact(CONTATO_NAME, API_DESCRICAO, CONTATO_EMAIL) )
				.build();
	}
}
