package com.interswitchgroup.crudwithsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.interswitchgroup.crudwithsp"})
public class CrudWithSpApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudWithSpApplication.class, args);
	}

}
