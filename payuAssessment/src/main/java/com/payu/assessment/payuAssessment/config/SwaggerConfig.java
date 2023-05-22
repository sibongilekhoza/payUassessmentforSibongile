package com.payu.assessment.payuAssessment.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig
{
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("sibongileAssessment").termsOfServiceUrl("").contact("Sibongile")
				.license("Sibongile License Version 1.0").licenseUrl("").version("1.0").build();
	}

	@Bean
	public Docket api() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.globalOperationParameters(Arrays.asList(new ParameterBuilder().name("Authorization")
						.modelRef(new ModelRef("string")).parameterType("header").required(false).hidden(true)
						.defaultValue("").build())).apiInfo(apiInfo());
	}

}
