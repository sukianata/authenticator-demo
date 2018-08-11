package com.example.authenticatordemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class AuthenticatorDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticatorDemoApplication.class, args);
	}
	
	@RequestMapping(value = "index",produces = "text/plain;charset=UTF-8")
    String index(){
        return "Hello Spring Boot!";
    }
	
	

}
