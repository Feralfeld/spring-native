package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;


@SpringBootApplication
@RestController
public class SpringNativeApplication {
//chmod 777 /var/run/docker.sock

	Logger logger = LoggerFactory.getLogger(SpringNativeApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringNativeApplication.class, args);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String get() {
		logger.info("Feralfeld");
		return "Feralfeld Test";
	}

	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public String test(Integer factor) {
		if(factor == null || factor <= 0 ){
			return "factor error";
		}
		double soma = 0;
		for(int i =0 ; i <= factor; i++){
			for(int j =0 ; j <= factor; j++){
			soma++;
			}
		}
		logger.info("quantidade de iterações: "+ soma);
		return "ok";
	}
}
