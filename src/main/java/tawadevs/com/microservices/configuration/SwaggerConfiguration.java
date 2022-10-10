package tawadevs.com.microservices.configuration;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tawadevs.com.microservices.controller.UserController;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				//.apis(RequestHandlerSelectors.withClassAnnotation(UserController.class)).paths(PathSelectors.any())
				.build()
				.apiInfo(new ApiInfo("Tawadevs", "Microservices", "1.0", "http://tawadevs.com",
						new Contact("Gaby A. Carbajal", "tawadevs.com", "gabyalvarez159@gmail.com"),
						"Exclusise API for learning Tawadevs", "http://anfix.com", Collections.emptyList()));
	}
}
