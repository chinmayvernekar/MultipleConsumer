package com.chinmay.activemq;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TopicSubApplication  implements CommandLineRunner{
	
	

	public static void main(String[] args) {
		SpringApplication.run(TopicSubApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		  int n = 10; // Number of threads
	        for (int i = 0; i < n; i++) {
	        	MultiThreadTopicSniffer1 object1
	                = new MultiThreadTopicSniffer1();
	          
	        	object1.start();
	        }
		
	}

}
