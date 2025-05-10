package com.Book.Book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication // Spring Boot uygulaması olduğunu belirtir.
@EnableCaching         // Spring Cache mekanizmasını aktif hale getirir.
public class BookApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookApplication.class, args); // Uygulama başlatılır
	}

}
