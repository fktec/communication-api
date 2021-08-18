package br.com.communication.scheduling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "br.com.communication" })
public class CommunicationApiApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(CommunicationApiApplication.class, args);
	}

}
