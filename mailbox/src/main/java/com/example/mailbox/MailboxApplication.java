package com.example.mailbox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MailboxApplication {

	public static void main(String[] args) {
		SpringApplication.run(MailboxApplication.class, args);
	}

}
