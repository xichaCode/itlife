package com.itlife.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages ={"com.itlife.shop" })
public class ItlifeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItlifeApplication.class, args);
	}

}
