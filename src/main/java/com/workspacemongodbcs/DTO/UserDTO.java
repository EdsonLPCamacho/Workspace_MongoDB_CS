package com.workspacemongodbcs.DTO;

import java.io.Serializable;

import com.workspacemongodbcs.domain.User;

public class UserDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	//Attributes
	private String id;
	private String name;
	private String email;
	
	//Constructor
	public UserDTO() {
		
	}
	
	public UserDTO(User obj) {
		id = obj.getId();
		name  = obj.getName();
		email = obj.getEmail();
		
	}

	//Getters and setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
