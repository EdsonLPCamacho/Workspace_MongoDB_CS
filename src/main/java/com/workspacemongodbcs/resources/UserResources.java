package com.workspacemongodbcs.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.workspacemongodbcs.DTO.UserDTO;
import com.workspacemongodbcs.domain.User;
import com.workspacemongodbcs.services.UserService;

@RestController
@RequestMapping("/users")
public class UserResources {
	 
	@Autowired
	private UserService service;
	//List
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll(){	
		List<User> list = service.findAll(); 
		List<UserDTO> listDto  = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id){	
		User obj = service.findById(id);		
		return ResponseEntity.ok().body(new UserDTO(obj));
	}

}
