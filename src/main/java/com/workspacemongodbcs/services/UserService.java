package com.workspacemongodbcs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workspacemongodbcs.domain.User;
import com.workspacemongodbcs.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository reposit;
	public List<User> findAll(){
		return reposit.findAll();
	}
}
