package com.example.searchappv1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SearchAppV1Application {

	public static void main(String[] args) {
		SpringApplication.run(SearchAppV1Application.class, args);
	}

}
