package com.customer.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


    @Configuration
    @EnableSwagger2
    public class SwaggerConfiguration {

        @Bean
        Docket docket(){
            return new Docket(DocumentationType.SWAGGER_2)
                    .select().paths(PathSelectors.any())
                    .apis(RequestHandlerSelectors.basePackage("com.customer"))
                    .build().apiInfo((apiInfo()));
        }

		private ApiInfo apiInfo() {

			return new ApiInfo("Deals and Coupons",
	                "<h1>API reference example for Customer Microservice</h1>", "1.0.0", "Public API",
	                new springfox.documentation.service.Contact("Rohan Bhalerao", "https://github.com/Rohanbhalerao12345", "Bhalerao_rohan.me@ghrce.raisoni.net"),
	                "API License Open", "http://codeshark.com/");
		}
       
}