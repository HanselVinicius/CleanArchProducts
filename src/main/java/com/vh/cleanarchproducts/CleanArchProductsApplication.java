package com.vh.cleanarchproducts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CleanArchProductsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CleanArchProductsApplication.class, args);
	}

}
