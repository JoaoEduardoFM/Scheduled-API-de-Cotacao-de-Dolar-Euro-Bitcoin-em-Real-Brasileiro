package com.br.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.br.controller")).paths(PathSelectors.any()).build()
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("API de Cotação de Dólar, Euro e Bitcoin em Real Brasileiro").description(
				"Esta API de cotação de dólar, euro e bitcoin em real brasileiro fornece uma maneira simples e padronizada de acessar informações de câmbio atualizadas. Utilizando um escalonador parametrizado por um arquivo YAML, as cotações são buscadas regularmente e disponibilizadas através de endpoints específicos. Utilize esta API para integrar facilmente as cotações em seus aplicativos financeiros, serviços de conversão monetária e outras soluções relacionadas.")
				.version("1.0.0").build();
	}
}
