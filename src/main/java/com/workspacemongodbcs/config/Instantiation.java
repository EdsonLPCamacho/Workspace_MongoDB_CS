package com.workspacemongodbcs.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.workspacemongodbcs.domain.User;
import com.workspacemongodbcs.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		//Clear Database collection
		userRepository.deleteAll();
		
		User paul  = new User(null, "Paul Anka", "paul@paul.test");
		User elvis = new User(null, "Elvis Presley", "elvis@elvis.test");
		
		//Save all Collection
		userRepository.saveAll(Arrays.asList(paul, elvis));
		
	}

}


