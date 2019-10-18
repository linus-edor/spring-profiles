package com.springboot2.profiles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class ProfilesApplication {

	private static Logger log = LoggerFactory.getLogger(ProfilesApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ProfilesApplication.class, args);
	}

	@Value("${app.server-ip}")
	String serverIp;

	@Value("${spring.application.name}")
	String appName;

	@Autowired
	private String dbConnectionDetails;

	@Bean
	CommandLineRunner values() {
		return args -> {
			log.info(" > The App Name: " + appName);
			log.info(" > The Server IP: " + serverIp);
			log.info("DB connection details: " + dbConnectionDetails);
		};

	}

}
