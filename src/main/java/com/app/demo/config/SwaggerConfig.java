package com.app.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.app.demo.properties.APIProperties;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig
{
	@Autowired
	private APIProperties apiProperties;

	@Bean
	public Docket api() throws Exception
	{
		return new Docket( DocumentationType.SWAGGER_2).select()
						       .apis(RequestHandlerSelectors.basePackage( "com.app.demo.controller" ) )
						       .paths(PathSelectors.any())
						       .build()
						       .apiInfo(getApiInfo() );
	}

	private ApiInfo getApiInfo()
	{
		return new ApiInfo( apiProperties.getNombre(), 
							     apiProperties.getDescripcion(), 
							     apiProperties.getVersion(), 
							     null, 
							     new Contact( apiProperties.getNombreAutor(), 
							   		         apiProperties.getWebAutor(), 
							   		         apiProperties.getCorreoAutor() ), 
							     					null, null );
	}
}
