package com.appsdeveloperblog.rentalapp.api.rentals;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
public class RentalAppApiRentalsApplication {



	public static void main(String[] args) {
		SpringApplication.run(RentalAppApiRentalsApplication.class, args);

	}
	@Bean
	public ModelMapper getModelMapper(){

		ModelMapper modelMapper = new ModelMapper();
		return modelMapper;
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors
				.basePackage("com.appsdeveloperblog.rentalapp.api.rentals"))
				.build();
	}



}
