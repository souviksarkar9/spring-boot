package com.example.demo.swaggerconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
	
	@Bean
	public Docket paymentApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
				.select().apis(RequestHandlerSelectors.basePackage("com.example.demo"))
				.paths(PathSelectors.regex("/makepayment")).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Payment Api").description("Make Payment against orders")
				.termsOfServiceUrl("Payment Gateway").license("Payment Org").version("2.0").build();
	}

}
