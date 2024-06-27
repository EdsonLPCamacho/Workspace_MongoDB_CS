package com.workspacemongodbcs.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.workspacemongodbcs.DTO.AuthorDTO;
import com.workspacemongodbcs.domain.Post;
import com.workspacemongodbcs.domain.User;
import com.workspacemongodbcs.repository.PostRepository;
import com.workspacemongodbcs.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		//Clear Database collection
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User paul  = new User(null, "Paul Anka", "paul@paul.test");
		User elvis = new User(null, "Elvis Presley", "elvis@elvis.test");
		
		//Save all User Collection
		userRepository.saveAll(Arrays.asList(paul, elvis));
		
		Post post0 = new Post(null, sdf.parse("26/06/2024"), "I Love God, my family and my animals", "Gos is in our life, i pray for God every day!", new AuthorDTO(paul));
		
		//Save all Post Collection		
		postRepository.saveAll(Arrays.asList(post0));
		
	}

}


