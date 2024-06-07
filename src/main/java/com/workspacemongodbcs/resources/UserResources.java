package com.workspacemongodbcs.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.workspacemongodbcs.domain.User;

@RestController
@RequestMapping("/users")
public class UserResources {
	//List
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){
		User Paul = new User("1", "Paul Anka", "paul@paul.com");
		User John = new User("2", "John Travolta", "john@john.com");
		
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(Paul, John));
		
		return ResponseEntity.ok().body(list);
	}
}
