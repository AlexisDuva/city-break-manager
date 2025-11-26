package com.example.city_break_manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
        "com.example.city_break_manager",
        "org.springframework.boot.resttestclient"
})
public class CityBreakManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CityBreakManagerApplication.class, args);
	}

}
