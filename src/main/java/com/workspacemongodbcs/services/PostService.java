package com.workspacemongodbcs.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workspacemongodbcs.domain.Post;
import com.workspacemongodbcs.repository.PostRepository;
import com.workspacemongodbcs.services.exception.NotFoundException;

@Service
public class PostService {
    @Autowired
    private PostRepository repository;

    public List<Post> findAll() {
        return repository.findAll();
    }

    public Post findById(String id) {
        Optional<Post> obj = repository.findById(id);
        return obj.orElseThrow(() -> new NotFoundException("Post not found!"));
    }
  
}
