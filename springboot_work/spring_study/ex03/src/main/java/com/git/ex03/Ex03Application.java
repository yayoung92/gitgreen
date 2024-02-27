package com.git.ex03;

import com.git.ex03.component.BB;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Ex03Application {

	public static void main(String[] args) {

		//SpringApplication.run(Ex03Application.class, args);

		ApplicationContext context = SpringApplication.run(Ex03Application.class, args);
		String[] arr = context.getBeanDefinitionNames();
		for(String s : arr) {
			System.out.println(s);
		}


	}
	@Bean
	public BB bb(){
		return new BB();
	}
}


