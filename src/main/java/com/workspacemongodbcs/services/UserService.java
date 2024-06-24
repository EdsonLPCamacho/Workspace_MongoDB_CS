package com.workspacemongodbcs.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workspacemongodbcs.DTO.UserDTO;
import com.workspacemongodbcs.domain.User;
import com.workspacemongodbcs.repository.UserRepository;
import com.workspacemongodbcs.services.exception.NotFoundException;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(() -> new NotFoundException("User not found!"));
    }
    
    public User insert(User obj) {
    	return repository.insert(obj);
    }
    
    //Delete user
    public void delete(String id) {
    	findById(id);//Exception handling
    	repository.deleteById(id);
    	
    }
    
    public User fromDTO(UserDTO objDto) {
    	return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }
}
