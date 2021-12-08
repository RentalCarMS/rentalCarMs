package com.appsdeveloperblog.rentalapp.api.rentals;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import com.appsdeveloperblog.rentalapp.api.rentals.core.utilities.mapping.ModelMapperService;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
//@EnableSwagger2
public class RentalAppApiRentalsApplication {



	public static void main(String[] args) {
		SpringApplication.run(RentalAppApiRentalsApplication.class, args);

	}

	/*@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.appsdeveloperblog.rentalapp.api.rentals.RentalAppApiRentals"))
				.build();
	}*/
/*	@Bean
	public ModelMapper getModelMapper() {
		ModelMapper modelMapper=new ModelMapper();
		return modelMapper;
	}*/

	@Bean
	public ModelMapper getModelMapper(){

		ModelMapper modelMapper = new ModelMapper();
		return modelMapper;
	}
}
