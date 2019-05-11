package com.benali;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.benali.dao.UserRepository;

@ComponentScan
@SpringBootApplication
public class PhonesApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(PhonesApplication.class, args);
		UserRepository userRepository = ctx.getBean(UserRepository.class);
		

	}
}
