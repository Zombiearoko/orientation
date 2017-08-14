package com.bocobi2.orientation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import com.bocobi2.orientation.model.Customer;
import com.bocobi2.orientation.repositories.CustomerRepository;

//import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class OrientationApplication extends SpringBootServletInitializer   {

	
	public static void main(String[] args) {
		SpringApplication.run(OrientationApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
		return application.sources(OrientationApplication.class);
	}
	
	
}
