package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FirstProApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(FirstProApplication.class, args);
		Alien a = context.getBean(Alien.class);
		a.show();
//		Alien a2 = context.getBean(Alien.class);
//		a2.show();
	}

}
