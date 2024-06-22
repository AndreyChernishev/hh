package ru.turnikman.hh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
//@EnableAspectJAutoProxy
public class HeadHunterApplication {

	public static void main(String[] args) {
		SpringApplication.run(HeadHunterApplication.class, args);
	}

}
