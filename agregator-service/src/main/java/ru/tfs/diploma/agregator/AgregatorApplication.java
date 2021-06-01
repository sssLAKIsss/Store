package ru.tfs.diploma.agregator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class AgregatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgregatorApplication.class, args);
	}

}
