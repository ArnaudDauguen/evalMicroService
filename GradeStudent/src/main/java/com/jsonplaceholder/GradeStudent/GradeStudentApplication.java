package com.jsonplaceholder.GradeStudent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GradeStudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(GradeStudentApplication.class, args);
	}

}
