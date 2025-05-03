package com.example.openapi;

import com.example.openapi.client.ApiClient;
import com.example.openapi.client.api.BookApi;
import com.example.openapi.client.api.OrderApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class OpenapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenapiApplication.class, args);
	}


	@Bean
	public BookApi bookApi(){
		var apiClient = new ApiClient();
		apiClient.setBasePath("http://localhost:8081");
		return new BookApi(apiClient);
	}

	@Bean
	public OrderApi orderApi(){
		var apiClient = new ApiClient();
		apiClient.setBasePath("http://localhost:8082");
		return new OrderApi(apiClient);
	}
}
