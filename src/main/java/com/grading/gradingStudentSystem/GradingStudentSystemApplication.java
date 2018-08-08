package com.grading.gradingStudentSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan(basePackages = {"com"})
@EnableJpaRepositories
@EntityScan

public class GradingStudentSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(GradingStudentSystemApplication.class, args);

			}
	/*@Bean
	CommandLineRunner init(UserServiceImp userServiceImp) {

		return args ->

		userServiceImp.addUser(new UserEntity("shler", "mamandi", 4, 4, 4, 4, 4));


	}*/

}
