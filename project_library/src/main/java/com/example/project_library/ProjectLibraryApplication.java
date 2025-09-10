package com.example.project_library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients

public class ProjectLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectLibraryApplication.class, args);
	}

}
