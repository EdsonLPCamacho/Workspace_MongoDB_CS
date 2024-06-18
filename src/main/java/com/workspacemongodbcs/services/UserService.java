package com.workspacemongodbcs.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
