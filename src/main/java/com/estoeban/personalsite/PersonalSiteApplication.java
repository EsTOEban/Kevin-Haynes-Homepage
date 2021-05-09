package com.estoeban.personalsite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication
public class PersonalSiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonalSiteApplication.class, args);
	}

}
